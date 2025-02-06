import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private final List<Treasure> treasures;

    public Map(int rows, int columns, Treasure[] treasuresArray) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = new ArrayList<>();
        Collections.addAll(this.treasures, treasuresArray);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return !treasures.isEmpty();
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.position().equals(position)) {
                return treasure.score();
            }
        }
        return 0;
    }

    public void update(Position position) {
        treasures.removeIf(treasure -> treasure.position().equals(position));
    }
}
