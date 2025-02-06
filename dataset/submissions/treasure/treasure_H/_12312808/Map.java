public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = true;
    }

    public int update(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position) && !treasure.isCollected()) {
                treasure.collect();
                return treasure.getScore();
            }
        }
        return 0;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                if (treasure.isCollected()) {
                    return 0;
                } else {
                    return treasure.getScore();
                }
            }
        }
        return 0;
    }
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public boolean isActive() {
        for (Treasure treasure : treasures) {
            if (!treasure.isCollected()) {
                isActive = true;
                return true;
            }
        }
        isActive = false;
        return false;
    }
}
