
import java.util.*;

public class Map {
    private final int rows;
    private final int columns;
    private List<Treasure> treasures;
    private boolean isActive;

    // Constructor
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = new ArrayList<>(Arrays.asList(treasures)); // Create a new ArrayList
        this.isActive = true;
    }

    // Check if there is a treasure at the given position and return its score
    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    // Update the map by removing the treasure if it's found
    public void update(Position position) {
        Iterator<Treasure> iterator = treasures.iterator();
        while (iterator.hasNext()) {
            Treasure treasure = iterator.next();
            if (treasure.getPosition().equals(position)) {
                iterator.remove();
            }
        }
        this.isActive = !treasures.isEmpty();
    }


    // Check if the map is still active
    public boolean isActive() {
        return !treasures.isEmpty();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
