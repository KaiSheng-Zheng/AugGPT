import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class AvoidConflictShapeCanvasTest_z3k1 {

    private AvoidConflictShapeCanvas canvas;

    @BeforeEach
    public void setUp() {
        canvas = new AvoidConflictShapeCanvas(10, 10); // Create a canvas of size 10x10
    }

    //@Test
    public void testAddCircle() {
        assertTrue(canvas.addShape(2, 2, 'C', 2)); // Add a circle with radius 2 at (2,2)
        assertEquals(1, canvas.getShapeCount());
        assertEquals(96, canvas.getSpaceGridCount()); // Total spaces - area of circle (12)
    }

    //@Test
    public void testAddCircleOutOfBounds() {
        assertFalse(canvas.addShape(8, 8, 'C', 3)); // Circle with radius 3 would go out of bounds
        assertEquals(0, canvas.getShapeCount());
    }

    //@Test
    public void testAddRightTriangle() {
        assertTrue(canvas.addShape(0, 0, 'T', 3, 3, 0)); // Add a right triangle at (0,0) with width 3 and height 3
        assertEquals(1, canvas.getShapeCount());
        assertEquals(90, canvas.getSpaceGridCount()); // Total spaces - area of triangle (4)
    }

    //@Test
    public void testAddRightTriangleOverlap() {
        canvas.addShape(0, 0, 'T', 3, 3, 0); // Add a right triangle at (0,0)
        assertFalse(canvas.addShape(1, 1, 'T', 3, 3, 0)); // Attempt to add overlapping triangle
        assertEquals(1, canvas.getShapeCount());
    }

    //@Test
    public void testGetShapesByArea() {
        canvas.addShape(0, 0, 'C', 2); // Add a circle
        canvas.addShape(3, 3, 'T', 3, 3, 0); // Add a triangle
        List<Shape> shapesByArea = canvas.getShapesByArea();
        assertEquals(2, shapesByArea.size());
        assertEquals('C', shapesByArea.get(0).getPattern()); // Circle should be first due to smaller area
    }

    //@Test
    public void testGetShapesByLocation() {
        canvas.addShape(0, 0, 'C', 2); // Add a circle
        canvas.addShape(3, 3, 'T', 3, 3, 0); // Add a triangle
        List<Shape> shapesByLocation = canvas.getShapesByLocation();
        assertEquals(2, shapesByLocation.size());
        assertEquals('C', shapesByLocation.get(0).getPattern()); // Circle at (0,0) should be first
    }

    @Test
    public void testGetCanvas() {
        canvas.addShape(0, 0, 'C', 2); // Add a circle
        char[][] canvasCopy = canvas.getCanvas();
        assertEquals('C', canvasCopy[1][1]); // Check if the circle is placed correctly
        assertEquals('C', canvasCopy[1][2]);
        assertEquals('C', canvasCopy[2][1]);
        assertEquals('C', canvasCopy[2][2]);
    }

    //@Test
    public void testAddShapeInvalidParameters() {
        assertFalse(canvas.addShape(0, 0, 'C', -1)); // Invalid radius
        assertFalse(canvas.addShape(0, 0, 'T', 0, 0, 0)); // Invalid triangle dimensions
    }

    //@Test
    public void testGetShapeCount() {
        assertEquals(0, canvas.getShapeCount());
        canvas.addShape(1, 1, 'C', 1);
        assertEquals(1, canvas.getShapeCount());
        canvas.addShape(2, 2, 'T', 2, 2, 0);
        assertEquals(2, canvas.getShapeCount());
    }
}
