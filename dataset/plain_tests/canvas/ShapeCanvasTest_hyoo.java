import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ShapeCanvasTest_hyoo {

    private AvoidConflictShapeCanvas avoidCanvas;
    private OverLapShapeCanvas overlapCanvas;

    @BeforeEach
    public void setUp() {
        avoidCanvas = new AvoidConflictShapeCanvas(10, 10);
        overlapCanvas = new OverLapShapeCanvas(10, 10);
    }

    //@Test
    public void testAddCircleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(2, 2, 'C', 2)); // Adding a circle with radius 2
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(96, avoidCanvas.getSpaceGridCount()); // 100 - area of circle (π * r^2) ~ 12.57 ~ 13
    }

    //@Test
    public void testAddTriangleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(0, 0, 'T', 4, 3, 0)); // Adding a triangle
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(85, avoidCanvas.getSpaceGridCount()); // Total grid - area of triangle
    }

    @Test
    public void testAddShapeOutOfBounds() {
        assertFalse(avoidCanvas.addShape(10, 10, 'C', 1)); // Out of bounds
        assertEquals(0, avoidCanvas.getShapeCount());
    }

    //@Test
    public void testGetShapesByArea() {
        avoidCanvas.addShape(0, 0, 'C', 2);
        avoidCanvas.addShape(3, 3, 'T', 4, 3, 0);
        List<Shape> shapesByArea = avoidCanvas.getShapesByArea();
        assertEquals(2, shapesByArea.size());
        assertEquals('C', shapesByArea.get(0).getPattern());
    }

    //@Test
    public void testAddCircleToOverlapCanvas() {
        assertTrue(overlapCanvas.addShape(2, 2, 'C', 2)); // Adding a circle with radius 2
        assertEquals(1, overlapCanvas.getShapeCount());
        assertEquals(96, overlapCanvas.getSpaceGridCount()); // 100 - area of circle (π * r^2) ~ 12.57 ~ 13
    }

    //@Test
    public void testAddShapeOverlap() {
        assertTrue(overlapCanvas.addShape(0, 0, 'C', 2)); // Adding a circle with radius 2
        assertFalse(overlapCanvas.addShape(1, 1, 'C', 2)); // Overlapping circle
        assertEquals(1, overlapCanvas.getShapeCount());
    }

    @Test
    public void testGetShapesByLocation() {
        overlapCanvas.addShape(0, 0, 'C', 2);
        overlapCanvas.addShape(3, 3, 'T', 4, 3, 0);
        List<Shape> shapesByLocation = overlapCanvas.getShapesByLocation();
        assertEquals(2, shapesByLocation.size());
        assertEquals('C', shapesByLocation.get(0).getPattern());
    }

    @Test
    public void testGetCanvas() {
        overlapCanvas.addShape(0, 0, 'C', 2);
        char[][] canvas = overlapCanvas.getCanvas();
        assertEquals('C', canvas[1][1]); // Circle should be in the canvas
        assertEquals('C', canvas[1][2]); // Circle should be in the canvas
        assertEquals('C', canvas[2][1]); // Circle should be in the canvas
        assertEquals('C', canvas[2][2]); // Circle should be in the canvas
    }
}
