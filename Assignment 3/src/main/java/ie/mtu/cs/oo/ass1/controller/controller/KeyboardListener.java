package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.projectview.projectView.Canvas;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;

/**
 * The KeyboardListener class handles keyboard events for controlling the game.
 * It listens for specific key presses to control player movements and game state.
 */
public class KeyboardListener implements EventHandler<KeyEvent>, Serializable {

    // File name for saving the game state
    private static final String SAVE_FILE_NAME = "Game.ser";

    // Instance of GameSerializer for saving and loading the game
    private final GameSerializer gameSerializer;

    // Current game instance
    private Game game;

    // Canvas where the game is rendered
    private Canvas canvas;

    // Flag indicating whether the game is paused
    private boolean isPaused = false;

    // Stores the paused ball speed
    private double pausedBallSpeedX;
    private double pausedBallSpeedY;

    /**
     * Constructs a new KeyboardListener object.
     *
     * @param game   The current game instance.
     * @param canvas The canvas where the game is rendered.
     */
    public KeyboardListener(Game game, Canvas canvas) {
        this.game = game;
        this.canvas = canvas;
        this.gameSerializer = GameSerializer.getInstance();
        new CreateFile(); // Ensure the save file exists
    }

    /**
     * Handles keyboard events.
     *
     * @param keyEvent The KeyEvent object representing the keyboard event.
     */
    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode key = keyEvent.getCode();
        if (key == KeyCode.P) {
            togglePause();
        } else if (key == KeyCode.R) {
            restartGame();
        } else if (key == KeyCode.F) {
            saveGame();
        } else if (key == KeyCode.G) {
            loadGame();
        } else if (!isPaused) {
            handleMovement(key);
        }
        canvas.drawGame(game);
    }

    /**
     * Handles movement based on keyboard input.
     *
     * @param key The KeyCode representing the pressed key.
     */
    private void handleMovement(KeyCode key) {
        switch (key) {
            case UP:
                game.getPlayer2Racket().moveUp();
                break;
            case DOWN:
                game.getPlayer2Racket().moveDown();
                break;
            case W:
                game.getPlayer1Racket().moveUp();
                break;
            case S:
                game.getPlayer1Racket().moveDown();
                break;
        }
    }

    /**
     * Toggles the game pause state.
     * Pauses or resumes the game and stops or restores the ball movement accordingly.
     */
    private void togglePause() {
        isPaused = !isPaused;
        if (isPaused) {
            // Store the current ball speed when pausing
            pausedBallSpeedX = game.getBall().getStepX();
            pausedBallSpeedY = game.getBall().getStepY();
            // Set the ball speed to 0 when pausing
            game.getBall().setStepX(0);
            game.getBall().setStepY(0);
        } else {
            // Restore the ball speed when resuming
            game.getBall().setStepX(pausedBallSpeedX);
            game.getBall().setStepY(pausedBallSpeedY);
        }
    }

    /**
     * Restarts the game.
     * Resets the game state and scores to the initial state.
     */
    private void restartGame() {
        isPaused = false;
        resetGame();
    }

    /**
     * Resets the game state.
     * Sets the ball and player positions, and resets scores to zero.
     */
    private void resetGame() {
        game.getPlayer1().setScore(0);
        game.getPlayer2().setScore(0);
        game.getBall().setPosX(350);
        game.getBall().setPosY(300);
        game.getBall().setStepX(2.5);
        game.getBall().setStepY(2.5);
    }

    /**
     * Saves the current game state.
     */
    private void saveGame() {
        gameSerializer.saveGame(game);

        // Display alert message for successful saving
        Alert saveSuccessAlert = new Alert(Alert.AlertType.INFORMATION);
        saveSuccessAlert.setTitle("Game Saved!");
        saveSuccessAlert.setHeaderText(null);
        saveSuccessAlert.setContentText("The game has been successfully saved.");
        saveSuccessAlert.showAndWait();
    }


    /**
     * Loads a previously saved game state.
     */
    public void loadGame() {
        Game loadedGame = gameSerializer.loadGame();
        if (loadedGame != null) {
            game.setPlayer1(loadedGame.getPlayer1());
            game.setPlayer2(loadedGame.getPlayer2());
            game.setBall(loadedGame.getBall());

            // Show a confirmation message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Loaded!");
            alert.setHeaderText(null);
            alert.setContentText("The saved game has been loaded.");
            alert.showAndWait();
        }
    }

    /**
     * Utility class to create the save file if it doesn't exist.
     */
    public class CreateFile {
        public CreateFile() {
            try {
                File myObj = new File(SAVE_FILE_NAME);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the save file.");
                e.printStackTrace();
            }
        }
    }

    // Getters and setters

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public double getPausedBallSpeedX() {
        return pausedBallSpeedX;
    }

    public void setPausedBallSpeedX(double pausedBallSpeedX) {
        this.pausedBallSpeedX = pausedBallSpeedX;
    }

    public double getPausedBallSpeedY() {
        return pausedBallSpeedY;
    }

    public void setPausedBallSpeedY(double pausedBallSpeedY) {
        this.pausedBallSpeedY = pausedBallSpeedY;
    }

    public GameSerializer getGameSerializer() {
        return gameSerializer;
    }
}
