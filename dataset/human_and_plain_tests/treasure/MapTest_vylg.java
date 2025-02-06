import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MapTest_vylg {
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(5, 5, new Treasure[]{new Treasure(10, new Position(1, 1)), new Treasure(20, new Position(2, 2))});
    }

    @Test
    void testHasTreasure() {
        assertEquals(10, map.hasTreasure(new Position(1, 1)));
        assertEquals(20, map.hasTreasure(new Position(2, 2));
        assertEquals(0, map.hasTreasure(new Position(0, 0)));
    }

    @Test
    void testUpdate() {
        map.update(new Position(1, 1)); // Collect treasure at (1,1)
        assertEquals(0, map.hasTreasure(new Position(1, 1))); // Treasure should be gone
        assertTrue(map.isActive()); // Map should still be active

        map.update(new Position(2, 2)); // Collect treasure at (2,2)
        assertEquals(0, map.hasTreasure(new Position(2, 2))); // Treasure should be gone
        assertFalse(map.isActive()); // Map should be inactive now
    }
}

