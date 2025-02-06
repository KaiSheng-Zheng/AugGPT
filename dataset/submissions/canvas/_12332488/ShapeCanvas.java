import java.util.List;

/**
 * The ShapeCanvas interface defines the structure for managing a canvas
 * that holds various shapes. This interface specifies methods to add shapes,
 * get count of shapes, and retrieve them based on certain criteria.
 */
public interface ShapeCanvas {

    /**
     * Adds a shape to the canvas at specified coordinates with a given pattern and additional parameters.
     * The parameters depend on the type of shape being added.
     *
     * @param x      the x-coordinate on the canvas where the shape starts.
     * @param y      the y-coordinate on the canvas where the shape starts.
     * @param pattern the character pattern that represents the shape on the canvas.
     * @param params additional parameters for the shape, such as radius or dimensions.
     * @return true if the shape was added successfully, false otherwise (e.g., if it conflicts with existing shapes).
     */
    public boolean addShape(int x, int y, char pattern, int... params);

    /**
     * Returns the count of grid spaces that are still empty (not occupied by any part of a shape).
     *
     * @return the number of empty grid spaces on the canvas.
     */
    public int getSpaceGridCount();

    /**
     * Returns the number of shapes that have been successfully added to the canvas.
     *
     * @return the count of shapes on the canvas.
     */
    public int getShapeCount();

    /**
     * Retrieves a list of all shapes on the canvas, sorted first by the area of the shapes in ascending order,
     * and then by the character value of their pattern in ascending order if areas are the same.
     *
     * @return a sorted list of shapes based on area and pattern.
     */
    public List<Shape> getShapesByArea();

    /**
     * Retrieves a list of all shapes on the canvas, sorted first by the x-coordinate of their location in ascending order,
     * and then by the y-coordinate in ascending order if x-values are the same.
     *
     * @return a sorted list of shapes based on their locations.
     */
    public List<Shape> getShapesByLocation();

    /**
     * Generates and returns a 2D character array that visually represents the current state of the canvas.
     * Each cell in the array corresponds to a point on the canvas; it contains a character representing
     * a shape's pattern if the point is occupied by a shape, or a space character if it is empty.
     *
     * @return a 2D character array representing the painted canvas.
     */
    public char[][] getCanvas();
}
