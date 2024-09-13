package ie.mtu.cs.oo.ass1.model;

/**
 * The Resizable interface represents objects that can be resized along the X and Y axes.
 */
public interface Resizable {

    /**
     * Resizes the object along the X-axis by a given factor.
     *
     * @param factor The factor by which to resize the object along the X-axis.
     */
    void resizeX(double factor);

    /**
     * Resizes the object along the Y-axis by a given factor.
     *
     * @param factor The factor by which to resize the object along the Y-axis.
     */
    void resizeY(double factor);
}
