import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class ShapeCanvasTest_xcl5 {
    private AvoidConflictShapeCanvas avoidCanvas;
    private OverLapShapeCanvas overlapCanvas;

    @BeforeEach
    public void setUp() {
        avoidCanvas = new AvoidConflictShapeCanvas(10, 10);
        overlapCanvas = new OverLapShapeCanvas(10, 10);
    }

    //@Test
    public void testAddCircleToAvoidConflictCanvas() {
        assertTrue(avoidCanvas.addShape(1, 1, 'C', 2)); // Circle with radius 2
        assertEquals(1, avoidCanvas.getShapeCount());
        assertEquals(96, avoidCanvas.getSpaceGridCount()); // 100 - 4 (area of circle)
    }
}
