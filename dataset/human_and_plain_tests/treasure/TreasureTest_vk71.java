import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
class TreasureTest_vk71 {
    @Test
    void testTreasure() {
        Position pos = new Position(1, 1);
        Treasure treasure = new Treasure(50, pos);
        
        assertEquals(50, treasure.getScore());
        assertEquals(pos, treasure.getPosition());
        
        treasure.setScore(0);
        assertEquals(0, treasure.getScore()); // Score should be updated
    }
}