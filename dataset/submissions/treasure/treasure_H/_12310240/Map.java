public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getPosition().equals(position)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public void update(Position position) {
        int treasureIndex = hasTreasure(position);
        if (treasureIndex != -1) {
            treasures[treasureIndex] = null;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
