package ie.mtu.cs.oo.ass1.model;


/**
 * The Player class represents a player in the game.
 */
public class Player {
    private String name;
    private int score;
    private double positionX;
    private double positionY;

    private double namePosX;
    private double namePosY;


    /**
     * Constructs a new Player object with the specified name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public double getNamePosX() {
        return namePosX;
    }

    public void setNamePosX(double namePosX) {
        this.namePosX = namePosX;
    }

    public double getNamePosY() {
        return namePosY;
    }

    public void setNamePosY(double namePosY) {
        this.namePosY = namePosY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void increaseScore() {
        score++;
    }
}
