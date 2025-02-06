import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position pos) {
        for (Treasure treasure : treasures) {
            if (treasure.getPos().equals(pos)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position pos) {
        treasures = Arrays.stream(treasures)
                .filter(treasure -> !treasure.getPos().equals(pos))
                .toArray(Treasure[]::new);
        if (treasures.length == 0) {
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
