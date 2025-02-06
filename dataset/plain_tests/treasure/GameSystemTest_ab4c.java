import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class GameSystemTest_ab4c {
    private GameSystem gameSystem;
    private Map map;

    @BeforeEach
    void setUp() {
        gameSystem = new GameSystem();
        map = gameSystem.newGame(5, 5, new Treasure(10, new Position(1, 1)), new Treasure(20, new Position(2, 2)));
    }

    @Test
    void testAddPlayer() {
        Player player = new Player(map, new Position(0, 0));
        gameSystem.addPlayer(player);
        assertEquals(1, gameSystem.players.size());
    }

    //@Test
    void testGetWinner() {
        Player player1 = new Player(map, new Position(0, 0));
        Player player2 = new Player(map, new Position(0, 1));
        gameSystem.addPlayer(player1);
        gameSystem.addPlayer(player2);
        
        player1.move(Direction.RIGHT, 1); // Moves to (0,1) and collects treasure
        player2.move(Direction.DOWN, 2); // Moves to (2,1) with no treasure
        
        Player winner = gameSystem.getWinner();
        assertEquals(player1.getId(), winner.getId());
    }
}

