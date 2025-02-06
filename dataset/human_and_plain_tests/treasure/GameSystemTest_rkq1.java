import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_rkq1 {
    private GameSystem gameSystem;
    private Map map;
    private Player player1;
    private Player player2;
    private Position position1;
    private Position position2;
    private Treasure treasure;

    @BeforeEach
    void setUp() {
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
    void testAddPlayer() {
        assertEquals(2, gameSystem.players.size());
        Player player3 = new Player(map, new Position(2, 2));
        gameSystem.addPlayer(player3);
        assertEquals(3, gameSystem.players.size());
    }

    @Test
    void testNewGame() {
        assertNotNull(map);
        assertEquals(5, map.getRows());
        assertEquals(5, map.getColumns());
        assertTrue(map.isActive());
    }

    @Test
    void testGetWinner() {
        player1.move(Direction.RIGHT, 1); // Move to (0, 1) and collect treasure
        player2.move(Direction.DOWN, 1); // Move to (1, 1), no treasure
        
        Player winner = gameSystem.getWinner();
        assertEquals(player1, winner);
    }

    @Test
    void testMapHasTreasure() {
        assertEquals(10, map.hasTreasure(new Position(0, 1)));
        assertEquals(0, map.hasTreasure(new Position(1, 1)));
    }

    @Test
    void testMapUpdate() {
        assertTrue(map.isActive());
        map.update(new Position(0, 1)); // Update treasure position
        assertEquals(0, map.hasTreasure(new Position(0, 1)));
        assertFalse(map.isActive()); // Map should be inactive after treasure collected
    }

    @Test
    void testPlayerMove() {
        assertTrue(player1.move(Direction.RIGHT, 1)); // Move to (0, 1) and collect treasure
        assertEquals(10, player1.getScore());
        assertEquals(1, player1.getSteps());
        assertEquals(1, player1.getPosition().getCol());

        // Attempt to move out of bounds
        assertFalse(player1.move(Direction.RIGHT, 5)); // Should not move beyond the map
        assertEquals(1, player1.getPosition().getCol()); // Should remain at (0, 1)
    }

    //@Test
    void testPlayerMoveWithMaxSteps() {
        Player limitedPlayer = new Player(map, position1, 2);
        assertTrue(limitedPlayer.move(Direction.RIGHT, 1)); // Move to (0, 1)
        assertTrue(limitedPlayer.move(Direction.DOWN, 1)); // Move to (1, 1)
        assertFalse(limitedPlayer.move(Direction.DOWN, 1)); // Should not move as max steps reached
        assertEquals(2, limitedPlayer.getSteps());
    }

    @Test
    void testPlayerEquals() {
        assertEquals(player1, player1); // Same instance
        assertNotEquals(player1, player2); // Different instances
    }
}
