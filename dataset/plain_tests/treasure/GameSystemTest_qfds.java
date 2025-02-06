import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_qfds {
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
        Player player3 = new Player(map, new Position(2, 2));
        gameSystem.addPlayer(player3);
        assertEquals(3, gameSystem.players.size());
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
        player2.move(Direction.UP, 1); // Move out of bounds (should not move)
        assertEquals(player1, gameSystem.getWinner());
    }

    @Test
    public void testHasTreasure() {
        assertEquals(10, map.hasTreasure(new Position(0, 1))); // Position with treasure
        assertEquals(0, map.hasTreasure(new Position(1, 1))); // Position without treasure
    }

    @Test
    public void testUpdateMap() {
        map.update(new Position(0, 1)); // Collect treasure
        assertFalse(map.isActive()); // No more treasures, map should be inactive
        assertEquals(0, treasure.getScore()); // Treasure score should be updated to 0
    }

    @Test
    public void testPlayerMovement() {
        assertTrue(player1.move(Direction.RIGHT, 1)); // Move to (0, 1) and collect treasure
        assertEquals(10, player1.getScore()); // Score should be 10
        assertEquals(1, player1.getSteps()); // Steps should be 1
        assertEquals(1, player1.getPosition().getCol()); // Position should be updated

        // Attempt to move beyond the map boundaries
        assertFalse(player1.move(Direction.RIGHT, 10)); // Should return false, max steps reached
        assertEquals(1, player1.getPosition().getCol()); // Position should remain unchanged
    }

    //@Test
    public void testPlayerEquals() {
        Player player3 = new Player(map, position1);
        assertEquals(player1, player3); // Same position, should be equal
        assertNotEquals(player1, player2); // Different players, should not be equal
    }

    @Test
    public void testPositionEquals() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(1, 1);
        assertEquals(pos1, pos2); // Same coordinates, should be equal
        assertNotEquals(pos1, new Position(1, 2)); // Different coordinates, should not be equal
    }

    @Test
    public void testTreasureScoreUpdate() {
        Treasure newTreasure = new Treasure(5, new Position(2, 2));
        assertEquals(5, newTreasure.getScore());
        newTreasure.setScore(0);
        assertEquals(0, newTreasure.getScore()); // Score should be updated to 0
    }
}
