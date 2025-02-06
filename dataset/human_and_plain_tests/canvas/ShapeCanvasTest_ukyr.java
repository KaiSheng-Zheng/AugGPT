import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ShapeCanvasTest_ukyr {
    private AvoidConflictShapeCanvas avoidConflictCanvas;
    private OverLapShapeCanvas overlapCanvas;

    @BeforeEach
    public void setUp() {
        avoidConflictCanvas = new AvoidConflictShapeCanvas(5, 5);
        overlapCanvas = new OverLapShapeCanvas(5, 5);
    }

    //@Test
    public void testAddCircleToAvoidConflictCanvas() {
        assertTrue(avoidConflictCanvas.addShape(1, 1, '*', 1)); // Add circle with radius 1
        assertEquals(1, avoidConflictCanvas.getShapeCount());
        
        assertEquals(20, avoidConflictCanvas.getSpaceGridCount()); // 25 total grids - 5 occupied by circle
    }

    @Test
    public void testAddCircleOutOfBounds() {
        assertFalse(avoidConflictCanvas.addShape(5, 5, '*', 1)); // Out of bounds
        assertEquals(0, avoidConflictCanvas.getShapeCount());
    }

    //@Test
    public void testAddRightTriangleToAvoidConflictCanvas() {
        assertTrue(avoidConflictCanvas.addShape(0, 0, '#', 3, 3, 0)); // Add right triangle
        assertEquals(1, avoidConflictCanvas.getShapeCount());
        
        assertEquals(18, avoidConflictCanvas.getSpaceGridCount()); // 25 total grids - 7 occupied by triangle
    }

    @Test
    public void testCannotAddShapeWhenOccupied() {
        avoidConflictCanvas.addShape(0, 0, '*', 1);
        assertFalse(avoidConflictCanvas.addShape(0, 0, '#', 3, 3, 0)); // Attempt to overlap
        assertEquals(1, avoidConflictCanvas.getShapeCount()); // Should still be 1
    }

    //@Test
    public void testGetShapesByArea() {
        avoidConflictCanvas.addShape(0, 0, '*', 2); // Circle with radius 2
        avoidConflictCanvas.addShape(0, 2, '#', 3, 3, 0); // Right triangle
        List<Shape> shapesByArea = avoidConflictCanvas.getShapesByArea();
        
        assertEquals(2, shapesByArea.size());
        assertEquals('#', shapesByArea.get(0).getPattern()); // Triangle should come first due to smaller area
    }

    @Test
    public void testAddShapeToOverlapCanvas() {
        assertTrue(overlapCanvas.addShape(0, 0, '*', 1)); // Add circle with radius 1
        assertTrue(overlapCanvas.addShape(0, 0, '#', 3, 3, 0)); // Add right triangle, overlapping
        assertEquals(2, overlapCanvas.getShapeCount());
    }

    @Test
    public void testGetCanvas() {
        overlapCanvas.addShape(1, 1, '*', 1);
        char[][] canvas = overlapCanvas.getCanvas();
        assertEquals('*', canvas[1][1]);
        assertEquals(' ', canvas[0][0]);
    }

    //@Test
    public void testShapeCountAfterRemovingShape() {
        overlapCanvas.addShape(0, 0, '*', 1);
        overlapCanvas.addShape(1, 1, '#', 3, 3, 0);
        assertEquals(2, overlapCanvas.getShapeCount());
        overlapCanvas.addShape(0, 0, '*', 1); // Overlapping shape should not be added
        
        assertEquals(2, overlapCanvas.getShapeCount());
    }

    //@Test
    public void testSpaceGridCount() {
        overlapCanvas.addShape(0, 0, '*', 1);
        
        assertEquals(24, overlapCanvas.getSpaceGridCount()); // 25 total grids - 1 occupied
    }

    //@Test
    public void testEnlargeAndShrinkCircle() {
        Circle circle = new Circle(new Location(0, 0), '*', 2);
        
        assertEquals(12, circle.area()); // Area of a circle with radius 2
        circle.enlarge();
        assertEquals(16, circle.area()); // Area after enlarging
        circle.shrink();
        circle.shrink();
        assertEquals(12, circle.area()); // Back to original area
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(new Location(0, 0), '#', 3, 2);
        assertEquals(6, rectangle.area()); // Area of rectangle (3*2)
    }

    //@Test
    public void testRightTriangleArea() {
        RightTriangle triangle = new RightTriangle(new Location(0, 0), '@', 3, 3, Direction.LEFT_UP);
        
        assertEquals(5, triangle.area()); // Area of right triangle (0.5 * base * height)
    }
}
