import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ShapeCanvasTest_a0ka {
    private AvoidConflictShapeCanvas avoidCanvas;
    private OverLapShapeCanvas overlapCanvas;

    @BeforeEach
    public void setUp() {
        avoidCanvas = new AvoidConflictShapeCanvas(5, 5);
        overlapCanvas = new OverLapShapeCanvas(5, 5);
    }

    //@Test
    public void testAddCircleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(1, 1, 'C', 1)); // Add a circle with radius 1
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(20, avoidCanvas.getSpaceGridCount()); // 25 total - 5 occupied
    }

    @Test
    public void testAddCircleOutsideCanvas() {
        assertFalse(avoidCanvas.addShape(5, 5, 'C', 1)); // Outside bounds
        assertEquals(0, avoidCanvas.getShapeCount());
    }

    @Test
    public void testAddCircleWithConflict() {
        avoidCanvas.addShape(1, 1, 'C', 1);
        assertFalse(avoidCanvas.addShape(1, 1, 'C', 1)); // Conflict with existing circle
        assertEquals(1, avoidCanvas.getShapeCount());
    }

    //@Test
    public void testAddRightTriangleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(0, 0, 'T', 2, 2, 0)); // Add a right triangle
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(15, avoidCanvas.getSpaceGridCount()); // Adjust accordingly based on the triangle area
    }

    @Test
    public void testGetShapesByArea() {
        avoidCanvas.addShape(1, 1, 'C', 1); // Area 3
        avoidCanvas.addShape(0, 0, 'T', 2, 2, 0); // Area 2
        List<Shape> sortedShapes = avoidCanvas.getShapesByArea();
        assertEquals(2, sortedShapes.size());
        assertEquals('T', sortedShapes.get(0).getPattern()); // Triangle should come first by area
    }

    @Test
    public void testGetShapesByLocation() {
        avoidCanvas.addShape(1, 1, 'C', 1);
        avoidCanvas.addShape(0, 0, 'T', 2, 2, 0);
        List<Shape> sortedShapes = avoidCanvas.getShapesByLocation();
        assertEquals(2, sortedShapes.size());
        assertEquals('T', sortedShapes.get(0).getPattern()); // Triangle at (0,0) should come first
    }

    @Test
    public void testAddShapeToOverlapCanvas() {
        assertTrue(overlapCanvas.addShape(1, 1, 'C', 1)); // Add a circle with radius 1
        assertEquals(1, overlapCanvas.getShapeCount());
    }

    @Test
    public void testAddShapeWithOverlap() {
        overlapCanvas.addShape(1, 1, 'C', 1); // Add circle
        assertTrue(overlapCanvas.addShape(1, 1, 'T', 2, 2, 0)); // Add triangle overlapping the circle
        assertEquals(2, overlapCanvas.getShapeCount());
    }

    @Test
    public void testGetCanvasState() {
        overlapCanvas.addShape(1, 1, 'C', 1);
        char[][] canvasState = overlapCanvas.getCanvas();
        assertEquals('C', canvasState[1][1]); // Check if circle is placed correctly
    }

    //@Test
    public void testSpaceGridCount() {
        assertEquals(25, avoidCanvas.getSpaceGridCount()); // Initially all spaces
        avoidCanvas.addShape(1, 1, 'C', 1);
        assertEquals(20, avoidCanvas.getSpaceGridCount()); // 5 occupied by the circle
    }

    //@Test
    public void testAddRectangle() {
        assertTrue(overlapCanvas.addShape(0, 0, 'R', 2, 3)); // Assuming Rectangle can be added
        assertEquals(1, overlapCanvas.getShapeCount());
    }
}
