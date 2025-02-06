import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class PositionTest_g0yi {
    @Test
    void testEquals() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 0);
        Position pos3 = new Position(1, 1);

        assertEquals(pos1, pos2); // same position
        assertNotEquals(pos1, pos3); // different positions
    }
}

