package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.projectview.projectView.Canvas;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The KeyboardListener class handles keyboard events for controlling the game.
 * It listens for specific key presses to control player movements and game state.
 */
public class KeyboardListener implements EventHandler<KeyEvent> {

    private Game game;
    private Canvas canvas;
    private boolean isPaused = false;

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
}
