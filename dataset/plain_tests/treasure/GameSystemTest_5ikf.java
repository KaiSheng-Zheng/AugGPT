import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_5ikf {
    private GameSystem gameSystem;
    private Map map;
    private Player player1;
    private Player player2;
    private Position position1;
    private Position position2;
    private Treasure treasure;

    @BeforeEach
    public void setUp() {
        gameSystem = new GameSystem();
        position1 = new Position(0, 0);
        position2 = new Position(1, 1);
        treasure = new Treasure(10, new Position(0, 1));
        map = gameSystem.newGame(5, 5, treasure);
        player1 = new Player(map, position1);
        player2 = new Player(map, position2);
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);
    }

    @Test
    public void testAddPlayer() {
        assertEquals(2, gameSystem.players.size());
    }

    @Test
    public void testNewGame() {
        assertNotNull(map);
        assertEquals(5, map.getRows());
        assertEquals(5, map.getColumns());
        assertTrue(map.isActive());
    }

    @Test
    public void testGetWinner() {
        player1.move(Direction.RIGHT, 1); // Move to (0, 1) and collect treasure
        player2.move(Direction.DOWN, 1); // Move to (2, 1) and collect no treasure
        Player winner = gameSystem.getWinner();
        assertEquals(player1, winner);
    }

    @Test
    public void testHasTreasure() {
        assertEquals(10, map.hasTreasure(new Position(0, 1))); // There is a treasure at (0, 1)
        assertEquals(0, map.hasTreasure(new Position(1, 1))); // No treasure at (1, 1)
    }

    @Test
    public void testUpdateMap() {
        player1.move(Direction.RIGHT, 1); // Move to (0, 1) and collect treasure
        assertFalse(map.isActive()); // The map should be inactive after all treasures are collected
    }

    //@Test
    public void testPlayerMovement() {
        assertTrue(player1.move(Direction.RIGHT, 1)); // Move to (0, 1)
        assertEquals(1, player1.getScore());
        assertEquals(1, player1.getSteps());

        assertFalse(player1.move(Direction.UP, 1)); // Can't move up beyond the map
        assertEquals(0, player1.getPosition().getRow());
        assertEquals(1, player1.getPosition().getCol());
    }

    //@Test
    public void testPlayerScoreAndSteps() {
        player1.move(Direction.RIGHT, 1); // Move to (0, 1) and collect treasure
        assertEquals(1, player1.getScore());
        assertEquals(1, player1.getSteps());

        player2.move(Direction.LEFT, 1); // Move to (1, 0)
        assertEquals(0, player2.getScore());
        assertEquals(1, player2.getSteps());
    }
}
