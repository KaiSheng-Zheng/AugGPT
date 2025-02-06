import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class MapTest_iaxc {
    private Map map;
    private Position position;
    private Treasure treasure;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        treasure = new Treasure(10, position);
        map = new Map(5, 5, new Treasure[]{treasure});
    }

    @Test
    void testHasTreasure() {
        assertEquals(10, map.hasTreasure(position));
        assertEquals(0, map.hasTreasure(new Position(1, 1)));
    }

    @Test
    void testUpdateTreasure() {
        map.update(position);
        assertEquals(0, treasure.getScore());
        assertFalse(map.isActive()); // should remain active since treasure is still there
    }
}

