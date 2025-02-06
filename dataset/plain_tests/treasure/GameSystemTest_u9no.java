import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_u9no {
    private GameSystem gameSystem;
    private Map map;
    private Position position1;
    private Position position2;
    private Treasure treasure1;
    private Treasure treasure2;

    @BeforeEach
    public void setUp() {
        gameSystem = new GameSystem();
        position1 = new Position(0, 0);
        position2 = new Position(1, 1);
        treasure1 = new Treasure(10, new Position(0, 0));
        treasure2 = new Treasure(20, new Position(1, 1));
        map = gameSystem.newGame(5, 5, treasure1, treasure2);
    }

    @Test
    public void testAddPlayer() {
        Player player = new Player(map, position1);
        gameSystem.addPlayer(player);
        assertEquals(1, gameSystem.getPlayersCount()); // Assuming a method to get player count exists
    }

    @Test
    public void testNewGame() {
        assertEquals(5, map.getRows());
        assertEquals(5, map.getColumns());
        assertTrue(map.isActive());
        assertEquals(2, map.getTreasures().length); // Assuming a method to get treasures exists
    }

    @Test
    public void testGetWinner() {
        Player player1 = new Player(map, position1);
        Player player2 = new Player(map, position2);
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        player1.move(Direction.RIGHT, 1); // Player 1 collects treasure1
        player2.move(Direction.LEFT, 1); // Player 2 does not collect any treasure

        Player winner = gameSystem.getWinner();
        assertEquals(player1.getId(), winner.getId()); // Player 1 should be the winner
    }

    //@Test
    public void testPlayerMovement() {
        Player player = new Player(map, position1);
        gameSystem.addPlayer(player);

        assertTrue(player.move(Direction.RIGHT, 1)); // Move right to (0, 1)
        assertEquals(1, player.getScore()); // Player should collect treasure1
        assertEquals(1, player.getSteps()); // Player should have taken 1 step

        assertFalse(player.move(Direction.DOWN, 10)); // Trying to move beyond max allowed steps
        assertEquals(1, player.getScore()); // Score should remain the same
        assertEquals(1, player.getSteps()); // Steps should remain the same
    }

    @Test
    public void testHasTreasure() {
        assertEquals(10, map.hasTreasure(position1)); // Treasure at (0, 0)
        assertEquals(20, map.hasTreasure(position2)); // Treasure at (1, 1)
        assertEquals(0, map.hasTreasure(new Position(2, 2))); // No treasure at (2, 2)
    }

    //@Test
    public void testUpdateMap() {
        map.update(position1); // Update treasure at (0, 0)
        assertEquals(0, treasure1.getScore()); // Treasure should be set to 0
        assertFalse(map.isActive()); // Map should be inactive if all treasures are collected
    }
}
