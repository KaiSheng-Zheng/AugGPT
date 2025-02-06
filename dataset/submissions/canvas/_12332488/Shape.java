import java.util.Arrays;

/**
 * The Shape class is an abstract class, representing the base class for various shapes. It defines the common attributes and methods of shapes.
 * All shapes contain a grid (grids), a pattern to fill the grid, and a location.
 * The location refers to the upper left corner coordinates of the shape on the canvas.
 */
public abstract class Shape
{
    // Grid, represented by a two-dimensional character array, stores the pixels of the shape.
    protected char[][] grids;

    // The pattern character that fills the shape.
    protected char pattern;

    // The location of the shape on the canvas, the coordinates of the location refer to the upper left corner of the shape.
    protected Location location;

    /**
     * The constructor for the Shape class, initializes the location and fill pattern of the shape.
     *
     * @param location The location of the shape
     * @param pattern  The pattern character used to fill the shape
     */
    public Shape(Location location, char pattern)
    {
        this.location = location;
        this.pattern = pattern;
        this.grids = new char[0][0]; // Initialize to an empty grid, the specific size is defined by the subclass
    }

    /**
     * This static method is used to create a Shape object based on the provided parameters.
     * The method receives x and y coordinates, a character pattern, and a variable number of additional parameters.
     * The additional parameters are used to determine the type of Shape to create and its specific properties.
     * <p>
     * If the length of the additional parameters is 1, a Circle object will be created. The single parameter is used as the radius of the Circle.
     * If the length of the additional parameters is 3, a RightTriangle object will be created. The parameters are used as the width, height, and direction index of the RightTriangle.
     *
     * @param x       The x-coordinate on the canvas where the shape begins.
     * @param y       The y-coordinate on the canvas where the shape begins.
     * @param pattern The character pattern that represents the shape on the canvas.
     * @param params  The additional parameters of the shape, such as the radius of the Circle, or the width, height, and direction index of the RightTriangle.
     * @return Returns a Shape object of type Circle or RightTriangle based on the provided parameters. If the parameters do not match any known Shape type, null is returned.
     */
    public static Shape createShape(int x, int y, char pattern, int... params)
    {
        Location location = new Location(x, y);
        if (params.length == 1)
        {
            int radius = params[0];
            return new Circle(location, pattern, radius);
        } else if (params.length == 3)
        {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction direction = Direction.values()[directionIndex];
            return new RightTriangle(location, pattern, width, height, direction);
        }
        return null;
    }

    /**
     * Get the grid data of the shape.
     *
     * @return Grid data, two-dimensional character array
     */
    public char[][] getGrids()
    {
        return grids;
    }

    /**
     * Abstract method, used to fill grid data.
     */
    public abstract void fillGrids();

    /**
     * Abstract method, used to enlarge the shape.
     * In Circle, the radius should be increased by 1.
     * In RightTriangle, the height and width should be increased by 1.
     */
    public abstract void enlarge();

    /**
     * Abstract method, used to shrink the shape.
     * In Circle, the radius should be decreased by 1.
     * In RightTriangle, the height and width should be decreased by 1.
     */
    public abstract void shrink();

    /**
     * Abstract method, calculate and return the number of grids filled with the pattern in the shape.
     *
     * @return The number of grids filled with the pattern
     */
    public abstract int area();

    /**
     * Generate a string representation of the shape.
     *
     * @return The string description of the shape, including location, area, and fill pattern.
     */
    @Override
    public String toString()
    {
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                this.getClass().getSimpleName(),
                location.getX(), location.getY(),
                this.area(), pattern);
    }

    /**
     * This method is used to get the location of the shape.
     *
     * @return A Location object, which represents the position of the shape on the canvas.
     * The coordinates of the location refer to the upper left corner of the shape.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * This method is used to get the fill pattern of the shape.
     *
     * @return A char type, which represents the pattern character used to fill the shape.
     */
    public char getPattern()
    {
        return pattern;
    }
}

/**
 * The Circle class represents a circle, and extends the Shape class.
 * It has a radius attribute, and can calculate area, fill the shape, etc.
 */
class Circle extends Shape
{
    private int radius;  // The radius of the circle

    /**
     * The constructor for the Circle class, initializes the circle's location, pattern, and radius.
     *
     * @param location The location of the circle, of type Location.
     * @param pattern  The pattern used to fill the circle, of type char.
     * @param radius   The radius of the circle, of type int.
     */
    public Circle(Location location, char pattern, int radius)
    {
        super(location, pattern);
        this.radius = radius;
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();  // Fill the shape
    }

    /**
     * Implements the fillGrids method from the Shape class, used to fill the circle.
     * <p>
     * We first consider 1/4 of the circle (upper left part), then mirror it to the entire circle.
     * Here we consider a Cartesian coordinate system with the upper left corner as the origin, grid[0][0] is in the square formed by the four points (0,0),(0,1),(1,0),(1,1).
     * For the upper left part, we only need to consider the lower right corner of this square. If the distance from this point to the center of the circle is less than or equal to the radius, then this square should be filled.
     * For grid[0][0], we only need to consider whether the distance from point (1,1) to the circle is less than the radius.
     * <p>
     * That is:
     * Consider grid[i][j], we consider the lower right corner of its square, whether the distance from point (i+1,j+1) to the center of the circle (radius,radius) is less than or equal to the radius.
     */
    @Override
    public void fillGrids()
    {
        // First consider 1/4 of the circle (upper left part)
        for (int i = 0; i < radius; i++)
        {
            for (int j = 0; j < radius; j++)
            {
                // Take the coordinates of the lower right corner of the square
                int dx = i + 1 - radius;
                int dy = j + 1 - radius;
                // Calculate the distance
                if (dx * dx + dy * dy < radius * radius)
                {
                    grids[i][j] = this.pattern;
                } else
                {
                    grids[i][j] = ' ';
                }
            }
        }
        // Mirror 1/4 of the circle to the entire circle, first mirror the upper right part
        for (int i = 0; i < radius; i++)
        {
            for (int j = radius; j < 2 * radius; j++)
            {
                grids[i][j] = grids[i][2 * radius - 1 - j];
            }
        }
        // Continue to mirror the lower half
        for (int i = radius; i < 2 * radius; i++)
        {
            for (int j = 0; j < 2 * radius; j++)
            {
                grids[i][j] = grids[2 * radius - 1 - i][j];
            }
        }
    }

    /**
     * Implements the enlarge method from the Shape class, increases the radius of the circle.
     */
    @Override
    public void enlarge()
    {
        this.radius++;
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    /**
     * Implements the shrink method from the Shape class, decreases the radius of the circle.
     */
    @Override
    public void shrink()
    {
        this.radius = Math.max(0, this.radius - 1);
        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }

    /**
     * Implements the area method from the Shape class, calculates and returns the number of cells occupied by the pattern in the circle.
     *
     * @return The number of cells occupied by the pattern, of type int.
     */
    @Override
    public int area()
    {
        int count = 0;
        for (int i = 0; i < 2 * radius; i++)
        {
            for (int j = 0; j < 2 * radius; j++)
            {
                if (grids[i][j] == this.pattern)
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Overrides the toString method, provides a description of the circle.
     *
     * @return The description string of the circle, in the format "Circle: ([x],[y]) area=[area] pattern=[pattern]"
     */
    @Override
    public String toString()
    {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), area(), pattern);
    }
}

/**
 * This class represents a right triangle, and extends the abstract class Shape.
 * This class contains the width, height, and right angle direction of the triangle.
 * It also provides methods to calculate the area of the triangle, and to fill a character grid based on the triangle's attributes.
 */
class RightTriangle extends Shape
{
    private int width;   // The width of the triangle
    private int height;  // The height of the triangle
    private final Direction d;  // The direction of the right angle

    /**
     * The constructor for the RightTriangle class.
     *
     * @param location The location of the upper left corner of the triangle
     * @param pattern  The character used to fill the triangle
     * @param width    The width of the triangle
     * @param height   The height of the triangle
     * @param d        The direction of the right angle
     */
    public RightTriangle(Location location, char pattern, int width, int height, Direction d)
    {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();  // Initialize the grid at construction
    }

    /**
     * Fill the grid to represent the right triangle.
     * Here we consider a Cartesian coordinate system with the upper left corner as the origin, grid[i][j] is in the square formed by the four points (i,j),(i,j+1),(i+1,j),(i+1,j+1).
     */
    @Override
    public void fillGrids()
    {
        grids = new char[height][width];
        for (char[] row : grids)
        {
            Arrays.fill(row, ' ');
        }

        switch (d)
        {
            case LEFT_DOWN:
                // For the lower left, consider whether the lower left corner (i+1,j) of the square is inside the hypotenuse
                // The equation of the hypotenuse is j = i * width / height
                for (int i = 0; i < height; i++)
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (j < (i + 1) * (double) width / height)
                        {
                            grids[i][j] = pattern;
                        } else
                        {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                // For the upper left, consider whether the upper left corner (i,j) of the square is inside the hypotenuse
                // The equation of the hypotenuse is j = - i * width / height + width
                for (int i = 0; i < height; i++)
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (j < -i * (double) width / height + width)
                        {
                            grids[i][j] = pattern;
                        } else
                        {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                // For the lower right, consider whether the lower right corner (i+1,j+1) of the square is outside the hypotenuse
                // The equation of the hypotenuse is j = - i * width / height + width
                for (int i = 0; i < height; i++)
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (j + 1 > -(i + 1) * (double) width / height + width)
                        {
                            grids[i][j] = pattern;
                        } else
                        {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                // For the upper right, consider whether the upper right corner (i,j+1) of the square is outside the hypotenuse
                // The equation of the hypotenuse is j = i * width / height
                for (int i = 0; i < height; i++)
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (j + 1 > i * (double) width / height)
                        {
                            grids[i][j] = pattern;
                        } else
                        {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    /**
     * Enlarge the size of the triangle.
     * Both the width and height increase by 1, and the grid is refilled.
     */
    @Override
    public void enlarge()
    {
        width++;
        height++;
        fillGrids();
    }

    /**
     * Shrink the size of the triangle.
     * Both the width and height decrease by 1, and the grid is refilled.
     */
    @Override
    public void shrink()
    {
        width = Math.max(1, width - 1);
        height = Math.max(1, height - 1);
        fillGrids();
    }

    /**
     * Calculate the number of grids filled with characters, i.e., the area of the triangle.
     *
     * @return The number of filled grids.
     */
    @Override
    public int area()
    {
        int count = 0;
        for (char[] row : grids)
        {
            for (char c : row)
            {
                if (c == pattern)
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Return a string representing the state of the triangle.
     * The format is: [RightTriangle]: ([x],[y]) area=[area] pattern=[pattern]
     */
    @Override
    public String toString()
    {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), area(), pattern);
    }
}

class Location
{
    private int x;
    private int y;

    // Constructor, initializes the location coordinates
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Get the x-coordinate
    public int getX()
    {
        return x;
    }

    // Get the y-coordinate
    public int getY()
    {
        return y;
    }

    // Override the toString method, return the location information in the form of "(x,y)"
    public String toString()
    {
        return String.format("(%d,%d)", x, y);
    }
}

enum Direction
{
    LEFT_UP,    // Upper left
    LEFT_DOWN,  // Lower left
    RIGHT_UP,   // Upper right
    RIGHT_DOWN  // Lower right
}