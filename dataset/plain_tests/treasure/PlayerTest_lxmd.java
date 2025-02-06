import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class PlayerTest_lxmd {
    private Player player;
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(5, 5, new Treasure[]{new Treasure(10, new Position(1, 1))});
        player = new Player(map, new Position(0, 0), 5);
    }

    //@Test
    void testMove() {
        assertTrue(player.move(Direction.RIGHT, 1)); // Move to (0,1)
        assertEquals(1, player.getSteps());
        assertEquals(0, player.getScore());

        assertTrue(player.move(Direction.DOWN, 1)); // Move to (1,1) and collect treasure
        assertEquals(1, player.getScore());
        assertEquals(2, player.getSteps());
        
        assertFalse(player.move(Direction.UP, 5)); // Exceed max steps
        assertEquals(2, player.getSteps()); // Steps should not increase
    }

    //@Test
    void testMoveOutOfBounds() {
        assertFalse(player.move(Direction.UP, 1)); // Attempt to move out of bounds
        assertEquals(0, player.getSteps()); // Steps should not increase
        assertEquals(0, player.getScore()); // Score should not change
    }
}

