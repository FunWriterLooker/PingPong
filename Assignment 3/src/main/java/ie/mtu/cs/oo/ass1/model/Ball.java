package ie.mtu.cs.oo.ass1.model;

import java.io.Serializable;

/**
 * The Ball class represents a ball object in the game.
 */
public class Ball implements Resizable, Serializable {

    private double posX;
    private double posY;
    private double radius;
    private double stepX;
    private double stepY;

    /**
     * Constructs a new Ball object with the specified position, radius, and movement steps.
     *
     * @param posX   The initial X-coordinate of the ball.
     * @param posY   The initial Y-coordinate of the ball.
     * @param radius The radius of the ball.
     * @param stepX  The step size in the X direction.
     * @param stepY  The step size in the Y direction.
     */
    public Ball(double posX, double posY, double radius, double stepX, double stepY) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getStepX() {
        return stepX;
    }

    public void setStepX(double stepX) {
        this.stepX = stepX;
    }

    public double getStepY() {
        return stepY;
    }

    public void setStepY(double stepY) {
        this.stepY = stepY;
    }

    @Override
    public void resizeX(double factor) {
        this.posX *= factor;
    }

    @Override
    public void resizeY(double factor) {
        this.posY *= factor;
    }

    /**
     * Moves the ball according to its current step sizes and reflects it when it reaches the game boundaries.
     *
     * @param minY The minimum Y-coordinate boundary of the game.
     * @param maxY The maximum Y-coordinate boundary of the game.
     */
    public void move(double minY, double maxY) {
        double nextPosY = posY + stepY;

        if (nextPosY - radius < minY || nextPosY + radius > maxY) {
            stepY = -stepY;
        }
        posX += stepX;
        posY += stepY;
    }
}
