import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_yaed {
    private GameSystem gameSystem;
    private Map map;
    private Position position1;
    private Position position2;
    private Treasure treasure1;
    private Treasure treasure2;

    @BeforeEach
    void setUp() {
        gameSystem = new GameSystem();
        position1 = new Position(0, 0);
        position2 = new Position(1, 1);
        treasure1 = new Treasure(10, new Position(0, 0));
        treasure2 = new Treasure(20, new Position(1, 1));
        map = gameSystem.newGame(5, 5, treasure1, treasure2);
    }

    @Test
    void testAddPlayer() {
        Player player = new Player(map, position1);
        gameSystem.addPlayer(player);
        assertEquals(1, gameSystem.players.size());
    }

    @Test
    void testNewGame() {
        assertEquals(5, map.getRows());
        assertEquals(5, map.getColumns());
        assertTrue(map.isActive());
    }

    //@Test
    void testGetWinner() {
        Player player1 = new Player(map, position1);
        Player player2 = new Player(map, position2);
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);

        player1.move(Direction.RIGHT, 1); // Move to (0, 1), no treasure
        player2.move(Direction.DOWN, 1); // Move to (1, 1), collect treasure2

        Player winner = gameSystem.getWinner();
        assertEquals(player2.getId(), winner.getId());
    }
}

