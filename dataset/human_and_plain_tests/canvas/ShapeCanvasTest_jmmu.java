import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ShapeCanvasTest_jmmu {

    private AvoidConflictShapeCanvas avoidCanvas;
    private OverLapShapeCanvas overlapCanvas;

    @BeforeEach
    public void setUp() {
        avoidCanvas = new AvoidConflictShapeCanvas(5, 5);
        overlapCanvas = new OverLapShapeCanvas(5, 5);
    }

    //@Test
    public void testAddCircleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(1, 1, '*', 1)); // Adding a circle with radius 1
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(24, avoidCanvas.getSpaceGridCount()); // 25 total - 1 occupied
    }

    @Test
    public void testAddCircleOutsideCanvas() {
        assertFalse(avoidCanvas.addShape(5, 5, '*', 1)); // Out of bounds
        assertEquals(0, avoidCanvas.getShapeCount());
    }

    @Test
    public void testAddOverlappingCircleToAvoidConflictCanvas() {
        avoidCanvas.addShape(1, 1, '*', 1);
        assertFalse(avoidCanvas.addShape(1, 1, '#', 1)); // Attempting to overlap
        assertEquals(1, avoidCanvas.getShapeCount());
    }

    //@Test
    public void testAddRectangleToOverlapCanvas() {
        assertTrue(overlapCanvas.addShape(0, 0, '#', 2, 2)); // Adding a rectangle 2x2
        assertEquals(1, overlapCanvas.getShapeCount());
        assertEquals(21, overlapCanvas.getSpaceGridCount()); // 25 total - 4 occupied
    }

    //@Test
    public void testAddOverlappingRectangleToOverlapCanvas() {
        overlapCanvas.addShape(0, 0, '#', 2, 2);
        assertTrue(overlapCanvas.addShape(1, 1, '*', 2, 2)); // Overlapping is allowed
        assertEquals(2, overlapCanvas.getShapeCount());
        assertEquals(17, overlapCanvas.getSpaceGridCount()); // 25 total - 8 occupied
    }

    //@Test
    public void testGetShapesByArea() {
        avoidCanvas.addShape(1, 1, '*', 1); // Area 3
        avoidCanvas.addShape(2, 2, '#', 2); // Area 12
        List<Shape> shapesByArea = avoidCanvas.getShapesByArea();
        assertEquals(2, shapesByArea.size());
        assertEquals('#', shapesByArea.get(0).getPattern()); // # should come first
    }

    @Test
    public void testGetCanvas() {
        avoidCanvas.addShape(1, 1, '*', 1);
        char[][] canvas = avoidCanvas.getCanvas();
        assertEquals('*', canvas[1][1]);
        assertEquals(' ', canvas[0][0]);
    }
}
