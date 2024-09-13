package ie.mtu.cs.oo.ass1.projectview.projectView;

import ie.mtu.cs.oo.ass1.model.Ball;
import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.model.Player;
import ie.mtu.cs.oo.ass1.model.Racket;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * The Canvas class represents the canvas where the game is showed.
 */
public class Canvas extends javafx.scene.canvas.Canvas {

    /**
     * Constructs a Canvas with the specified width and height.
     *
     * @param width  The width of the canvas.
     * @param height The height of the canvas.
     */
    public Canvas(double width, double height) {
        super(width, height);
    }

    /**
     * Draws the current state of the game on the canvas.
     *
     * @param game The current game state.
     */
    public void drawGame(Game game) {
        resetSize(game);
        GraphicsContext gc = this.getGraphicsContext2D();
        drawBackground(gc);
        drawBall(gc, game.getBall());

        drawRackets(gc, game.getRacket1(), game.getRacket2());

        game.getPlayer1().setNamePosX(20);
        game.getPlayer1().setNamePosY(50);
        game.getPlayer2().setNamePosX(game.getDimensionX() - 170);
        game.getPlayer2().setNamePosY(50);
        drawTitle(gc, game.getPlayer1());
        drawTitle(gc, game.getPlayer2());
        drawScores(gc, game.getPlayer1(), game.getPlayer2());
    }


    /**
     * Draws the ball on the canvas.
     *
     * @param gc   The GraphicsContext of the canvas.
     * @param ball The ball to draw.
     */

    private void drawBall(GraphicsContext gc, Ball ball) {
        gc.setFill(Color.YELLOWGREEN);
        gc.fillOval(ball.getPosX(), ball.getPosY(), ball.getRadius(), ball.getRadius());
    }

    /**
     * Draws the scores of the players on the canvas.
     *
     * @param gc      The GraphicsContext of the canvas.
     * @param player1 The first player.
     * @param player2 The second player.
     */
    private void drawScores(GraphicsContext gc, Player player1, Player player2) {
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.fillText(player1.getName() + " : " + player1.getScore(), player1.getNamePosX(), player1.getNamePosY() - 20);
        gc.fillText(player2.getName() + " : " + player2.getScore(), player2.getNamePosX(), player2.getNamePosY() - 20);
    }


    /**
     * Draws the rackets of the players on the canvas.
     *
     * @param gc      The GraphicsContext of the canvas.
     * @param racket1 The racket of the first player.
     * @param racket2 The racket of the second player.
     */
    private void drawRackets(GraphicsContext gc, Racket racket1, Racket racket2) {
        gc.setFill(racket1.getColor());
        gc.fillRect(racket1.getPosX(), racket1.getPosY(), racket1.getThickness(), racket1.getSize());
        gc.setFill(racket2.getColor());
        gc.fillRect(racket2.getPosX(), racket2.getPosY(), racket2.getThickness(), racket2.getSize());
    }


    /**
     * Resets the size of the canvas based on the dimensions of the game.
     *
     * @param game The current game state.
     */
    private void resetSize(Game game) {
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }


    /**
     * Draws the background of the canvas.
     *
     * @param gc The GraphicsContext of the canvas.
     */
    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        gc.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * Draws the title of a player on the canvas.
     *
     * @param gc     The GraphicsContext of the canvas.
     * @param player The player whose title is to be drawn.
     */

    private void drawTitle(GraphicsContext gc, Player player) {
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 25));
    }
}
