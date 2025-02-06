import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The AvoidConflictShapeCanvas class implements the ShapeCanvas interface and does not allow shapes to overlap on the canvas.
 * This class maintains a list of shapes and a two-dimensional character array as the canvas.
 */
public class AvoidConflictShapeCanvas implements ShapeCanvas
{
    private List<Shape> shapes;  // Stores the shapes that have been successfully added
    private char[][] canvas;     // Character array representing the canvas

    /**
     * Constructor initializes the canvas and the list of shapes.
     *
     * @param rows The number of rows in the canvas
     * @param cols The number of columns in the canvas
     */
    public AvoidConflictShapeCanvas(int rows, int cols)
    {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                this.canvas[i][j] = ' ';  // Initialize all cells to ' '
            }
        }
    }

    /**
     * Attempts to add a new shape to the canvas. If the shape can be fully placed within the canvas and does not overlap with other shapes, the addition is successful.
     *
     * @param x       The starting x-coordinate of the shape on the canvas
     * @param y       The starting y-coordinate of the shape on the canvas
     * @param pattern The fill character of the shape
     * @param params  The parameters of the shape (radius or width and height)
     * @return true if the shape is successfully added to the canvas, otherwise false
     */
    @Override
    public boolean addShape(int x, int y, char pattern, int... params)
    {
        Shape shape = Shape.createShape(x, y, pattern, params);

        // Check if it can be placed on the canvas and there is no conflict
        if (shape == null || canPlaceShape(shape, x, y) == false)
        {
            return false;
        }

        shapes.add(shape);
        placeShapeOnCanvas(shape, x, y);
        return true;
    }

    /**
     * Checks whether the shape can be placed at the specified position and checks for overlap.
     * This method traverses each cell of the shape to check whether it will exceed the boundary of the canvas after placement or overlap with other shapes.
     *
     * @param shape The shape to be placed
     * @param x     The starting x-coordinate of the shape on the canvas
     * @param y     The starting y-coordinate of the shape on the canvas
     * @return true if the shape can be placed at the specified position and does not overlap with other shapes, otherwise false
     */
    private boolean canPlaceShape(Shape shape, int x, int y)
    {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++)
        {
            for (int j = 0; j < shapeGrids[i].length; j++)
            {
                if (shapeGrids[i][j] != ' ')
                {
                    if (x + i >= canvas.length || y + j >= canvas[0].length || x + i < 0 || y + j < 0)
                    {
                        return false;  // Exceeds the canvas boundary
                    }
                    if (canvas[x + i][y + j] != ' ')
                    {
                        return false;  // There is overlap
                    }
                }
            }
        }
        return true;
    }

    /**
     * Places the shape on the canvas.
     * This method traverses each cell of the shape and places the cell of the shape in the corresponding position of the canvas.
     *
     * @param shape The shape to be placed
     * @param x     The starting x-coordinate of the shape on the canvas
     * @param y     The starting y-coordinate of the shape on the canvas
     */
    private void placeShapeOnCanvas(Shape shape, int x, int y)
    {
        char[][] shapeGrids = shape.getGrids();
        for (int i = 0; i < shapeGrids.length; i++)
        {
            for (int j = 0; j < shapeGrids[i].length; j++)
            {
                if (shapeGrids[i][j] != ' ')
                {
                    canvas[x + i][y + j] = shapeGrids[i][j];
                }
            }
        }
    }

    /**
     * Gets the number of empty cells on the canvas.
     *
     * @return The number of empty cells
     */
    @Override
    public int getSpaceGridCount()
    {
        int count = 0;
        for (int i = 0; i < canvas.length; i++)
        {
            for (int j = 0; j < canvas[i].length; j++)
            {
                if (canvas[i][j] == ' ')
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Gets the number of shapes successfully added to the canvas.
     *
     * @return The number of shapes
     */
    @Override
    public int getShapeCount()
    {
        return shapes.size();
    }

    /**
     * Gets all the shapes on the canvas, sorted by area. If the areas are the same, they are sorted by the pattern character.
     *
     * @return The sorted list of shapes
     */
    @Override
    public List<Shape> getShapesByArea()
    {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(new Comparator<Shape>()
        {
            @Override
            public int compare(Shape a, Shape b)
            {
                if (a.area() == b.area())
                {
                    return a.getPattern() - b.getPattern();
                }
                return Integer.compare(a.area(), b.area());
            }
        });
        return sortedShapes; // Returns the list of shapes sorted by area
    }

    /**
     * Gets all the shapes on the canvas, sorted by position. First sorted by x-coordinate, if the same, then sorted by y-coordinate.
     * If still the same, they are sorted by the pattern character.
     *
     * @return The sorted list of shapes
     */
    @Override
    public List<Shape> getShapesByLocation()
    {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(new Comparator<Shape>()
        {
            @Override
            public int compare(Shape a, Shape b)
            {
                Location locA = a.getLocation();
                Location locB = b.getLocation();
                if (locA.getX() == locB.getX())
                {
                    if (locA.getY() == locB.getY())
                    {
                        return a.getPattern() - b.getPattern();
                    }
                    return Integer.compare(locA.getY(), locB.getY());
                }
                return Integer.compare(locA.getX(), locB.getX());
            }
        });
        return sortedShapes; // Returns the list of shapes sorted by location
    }

    /**
     * Gets the character array representing the canvas.
     *
     * @return The character array of the canvas
     */
    @Override
    public char[][] getCanvas()
    {
        return canvas;
    }
}