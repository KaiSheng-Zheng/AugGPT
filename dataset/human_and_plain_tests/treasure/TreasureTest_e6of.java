import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class TreasureTest_e6of {
    @Test
    void testGetSetScore() {
        Position position = new Position(0, 0);
        Treasure treasure = new Treasure(10, position);
        
        assertEquals(10, treasure.getScore());
        treasure.setScore(15);
        assertEquals(15, treasure.getScore());
    }
}