package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Ball;
import ie.mtu.cs.oo.ass1.model.Game;
import ie.mtu.cs.oo.ass1.model.Player;
import ie.mtu.cs.oo.ass1.model.Racket;
import ie.mtu.cs.oo.ass1.projectview.projectView.Canvas;

import java.util.Random;

/**
 * The BallManager class is responsible for managing movement of the ball in the game.
 */
public class BallManager implements Runnable {
    private Game game;
    private Canvas canvas;
    private double minY;
    private double maxY;
    private boolean isPaused = false;

    private int numBounces = 0;

    private int speedIncreaseBall = 1;

    private Ball ball;


    /**
     * Constructs a new BallManager object.
     *
     * @param game   The current game instance.
     * @param canvas The canvas where the game is rendered.
     * @param minY   The minimum Y-coordinate for the ball's movement.
     * @param maxY   The maximum Y-coordinate for the ball's movement.
     */
    public BallManager(Game game, Canvas canvas, double minY, double maxY) {
        this.game = game;
        this.canvas = canvas;
        this.minY = minY;
        this.maxY = maxY;
        this.ball = game.getBall();

    }

    /**
     * Gets the winner of the game based on the players' scores.
     *
     * @return The player with the highest score, or null if it's a tie.
     */
    public Player getWinner() {
        int score1 = game.getPlayer1().getScore();
        int score2 = game.getPlayer2().getScore();
        if (score1 > score2) {
            return game.getPlayer1();
        } else if (score2 > score1) {
            return game.getPlayer2();
        } else {
            return null;
        }
    }

    /**
     * Runs the game loop, updating the ball's position and checking for collisions.
     */
    @Override
    public void run() {
        Ball ball = game.getBall();
        int counter = 0;
        while (true) {
            counter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!isPaused) {
                ball.move(minY, maxY);
                checkRacketCollision(ball);
                checkSpeedIncrease();
            }

            if (ball.getPosX() < 10) {
                game.getPlayer2().increaseScore();
                resetBallPosition();
            } else if (ball.getPosX() > game.getDimensionX() - ball.getRadius()) {
                game.getPlayer1().increaseScore();
                resetBallPosition();
            }


            if (checkEndOfGame(game)) {
                Player winner = getWinner();
                System.out.println("Game Fin!\n");
                if (winner != null) {
                    System.out.println("Player " + winner.getName() + " is the Winner!");
                } else {
                    System.out.println("It's a Tie!");
                }
                break;

            }
            canvas.drawGame(game);
        }
    }

    /**
     * Checks if the game has ended based on the maximum score limit.
     *
     * @param game The current game instance.
     * @return True if the game has ended, false otherwise.
     */
    public boolean checkEndOfGame(Game game) {
        int maxScore = game.getMaxScore();
        int maxScores = Math.max(game.getPlayer1().getScore(), game.getPlayer2().getScore());
        return maxScore <= maxScores;
    }

    /**
     * Checks if the ball has bounced enough times to increase its speed.
     */
    private void checkSpeedIncrease() {
        if (numBounces >= speedIncreaseBall) {
            double newStepX = ball.getStepX() * 1.2;
            double newStepY = ball.getStepY() * 1.2;
            ball.setStepX(newStepX);
            ball.setStepY(newStepY);
            numBounces = 0;
        }
    }

    /**
     * Resets the position of the ball to the center of the screen.
     */
    private void resetBallPosition() {
        Ball ball = game.getBall();
        ball.setPosX(game.getDimensionX() / 2);
        ball.setPosY(game.getDimensionY() / 2);
        ball.setStepX(-ball.getStepX());
        ball.setStepX(getRandomXSpeed());
        ball.setStepY(getRandomYSpeed());
        numBounces = 0;
    }

    /**
     * Generates a random speed for the ball along the X-axis.
     *
     * @return Random X-axis speed value.
     */
    public double getRandomXSpeed() {
        Random random = new Random();
        int sign = random.nextInt(2) == 0 ? -1 : 1;
        return sign * 2.5;
    }

    /**
     * Generates a random speed for the ball along the Y-axis.
     *
     * @return Random Y-axis speed value.
     */
    public double getRandomYSpeed() {
        Random random = new Random();
        return random.nextDouble() * 10 - 5;
    }

    /**
     * Checks if the ball collides with any of the rackets.
     *
     * @param ball The ball object.
     */
    public void checkRacketCollision(Ball ball) {
        double ballX = ball.getPosX();
        double ballY = ball.getPosY();
        double ballRadius = ball.getRadius();

        Racket racket1 = game.getRacket1();
        Racket racket2 = game.getRacket2();

        if (isCollidingWithRacket(ballX - ballRadius, ballY, racket1)) {
            ball.setStepX(-ball.getStepX());
            numBounces++;
        }

        if (isCollidingWithRacket(ballX + ballRadius, ballY, racket2)) {
            ball.setStepX(-ball.getStepX());
            numBounces++;
        }
    }

    /**
     * Checks if the ball collides with a racket.
     *
     * @param ballX  X-coordinate of the ball.
     * @param ballY  Y-coordinate of the ball.
     * @param racket The racket object.
     * @return True if the ball collides with the racket, false otherwise.
     */
    private boolean isCollidingWithRacket(double ballX, double ballY, Racket racket) {
        double racketRightX = racket.getPosX() + racket.getThickness();
        double racketBottomY = racket.getPosY() + racket.getSize();

        return ballX >= racket.getPosX() && ballX <= racketRightX &&
                ballY >= racket.getPosY() && ballY <= racketBottomY;
    }
}
