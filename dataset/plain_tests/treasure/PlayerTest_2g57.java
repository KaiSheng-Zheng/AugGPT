import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class PlayerTest_2g57 {
    private Player player;
    private Map map;
    private Position position;
    private Treasure treasure;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
        treasure = new Treasure(10, position);
        map = new Map(5, 5, new Treasure[]{treasure});
        player = new Player(map, position);
    }

    @Test
    void testMove() {
        assertTrue(player.move(Direction.RIGHT, 1)); // Move to (0, 1)
        assertEquals(1, player.getSteps());
        assertEquals(10, player.getScore()); // should collect treasure
    }

    @Test
    void testMoveOutOfBounds() {
        player.move(Direction.UP, 1); // Move out of bounds
        assertEquals(0, player.getPosition().getRow());
        assertEquals(0, player.getPosition().getCol()); // should remain at (0,0)
    }

    //@Test
    void testMaxSteps() {
        player = new Player(map, position, 1); // max 1 step
        assertFalse(player.move(Direction.RIGHT, 2)); // attempt to move 2 steps
        assertEquals(0, player.getSteps());
    }
}

