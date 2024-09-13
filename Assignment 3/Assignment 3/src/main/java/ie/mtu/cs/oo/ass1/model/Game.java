package ie.mtu.cs.oo.ass1.model;

import javafx.scene.paint.Color;


/**
 * The Game class represents the state and logic of the game.
 */
public class Game implements Resizable {
    private Player player1;
    private Player player2;
    private Ball ball;
    private Racket racket1;
    private Racket racket2;
    private int target;
    private double dimensionX;
    private double dimensionY;
    private int maxScore;


    /**
     * Constructs a new Game object with the specified players, ball, rackets, target score, dimensions, and maximum score.
     *
     * @param player1    The first player.
     * @param player2    The second player.
     * @param ball       The ball in the game.
     * @param racket1    The racket of player 1.
     * @param racket2    The racket of player 2.
     * @param target     The target score of the game.
     * @param dimensionX The width of the game area.
     * @param dimensionY The height of the game area.
     * @param maxScore   The maximum score allowed in the game.
     */
    public Game(Player player1, Player player2, Ball ball, Racket racket1, Racket racket2, int target, double dimensionX, double dimensionY, int maxScore) {
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        this.target = target;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;

        this.maxScore = maxScore;


        this.racket1 = racket1;
        this.racket2 = racket2;
        racket1.setColor(Color.DEEPSKYBLUE);
        racket1.setPosX(20);
        racket1.setPosY(dimensionY / 2 - racket1.getSize() / 2);

        racket2.setColor(Color.HOTPINK);
        racket2.setPosX(dimensionX - 20 - racket2.getThickness());
        racket2.setPosY(dimensionY / 2 - racket1.getSize() / 2);


    }

    @Override
    public void resizeX(double factor) {
        racket1.setPosX(racket1.getPosX() * factor);
        racket2.setPosX(racket2.getPosX() * factor);
        ball.setPosX(ball.getPosX() * factor);
    }

    @Override
    public void resizeY(double factor) {

        racket1.setPosY(racket1.getPosY() * factor);
        racket2.setPosY(racket2.getPosY() * factor);
        ball.setPosY(ball.getPosY() * factor);
    }


    public Racket getPlayer1Racket() {
        return racket1;
    }

    public Racket getPlayer2Racket() {
        return racket2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Racket getRacket1() {
        return racket1;
    }

    public void setRacket1(Racket racket1) {
        this.racket1 = racket1;
    }

    public Racket getRacket2() {
        return racket2;
    }

    public void setRacket2(Racket racket2) {
        this.racket2 = racket2;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public double getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
    }

    public double getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
