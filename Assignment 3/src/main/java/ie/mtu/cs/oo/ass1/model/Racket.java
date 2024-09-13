package ie.mtu.cs.oo.ass1.model;

import javafx.scene.paint.Paint;

import java.io.Serializable;


/**
 * The Racket class represents a racket object in the game.
 */
public class Racket implements Resizable , Serializable {

    private double posX;
    private double posY;
    private double thickness;
    private double size;
    private transient Paint color;

    private double maxY;
    private double minY;


    /**
     * Constructs a new Racket object with the specified position, thickness, size, and boundaries.
     *
     * @param posX      The initial X-coordinate of the racket.
     * @param posY      The initial Y-coordinate of the racket.
     * @param thickness The thickness of the racket.
     * @param size      The size of the racket.
     * @param maxY      The maximum Y-coordinate boundary of the racket's movement.
     * @param minY      The minimum Y-coordinate boundary of the racket's movement.
     */
    public Racket(double posX, double posY, double thickness, double size, double maxY, double minY) {
        this.posX = posX;
        this.posY = posY;
        this.thickness = thickness;
        this.size = size;
        this.maxY = maxY;
        this.minY = minY;
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

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public double getMinY() {
        return minY;
    }

    public void setMinY(double minY) {
        this.minY = minY;
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
     * Moves the racket up by a fixed amount, ensuring it does not go beyond the minimum Y-coordinate boundary.
     */
    public void moveUp() {
        if (posY - 10 >= minY) {
            posY -= 20;
        } else {
            posY = minY;
        }
    }

    /**
     * Moves the racket down by a fixed amount, ensuring it does not go beyond the maximum Y-coordinate boundary.
     */
    public void moveDown() {
        if (posY + 10 <= maxY) {
            posY += 20;
        } else {
            posY = maxY;
        }
    }


}
