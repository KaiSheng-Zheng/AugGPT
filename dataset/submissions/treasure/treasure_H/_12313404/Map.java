import java.util.*;
import java.util.stream.Collectors;

public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private List<Treasure> treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = List.of(treasures);
    }

    public int hasTreasure(Position position) {
        var ref = new Object() {
            int score = 0;
        };
        treasures.forEach((treasure) ->
                {
                    if (treasure.getPosition().equals(position)) {
                        ref.score = treasure.getScore();
                    }
                }
            );
        return ref.score;
    }

    public void update(Position position) {
        treasures = treasures.stream().filter((treasure) -> !treasure.getPosition().equals(position)).collect(Collectors.toList());
        if (treasures.isEmpty()) {
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
