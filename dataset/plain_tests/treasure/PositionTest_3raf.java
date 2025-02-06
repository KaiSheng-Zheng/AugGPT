import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class PositionTest_3raf {
    @Test
    void testEquals() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(1, 1);
        Position pos3 = new Position(2, 2);
        
        assertEquals(pos1, pos2); // Same position
        assertNotEquals(pos1, pos3); // Different positions
    }
}

