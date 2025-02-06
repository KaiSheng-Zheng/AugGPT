public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int treasureCount;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.treasureCount = treasures.length;
        this.isActive = true;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasureCount; i++) {
            if (treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasureCount; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = treasures[treasureCount - 1];
                treasureCount--;
                break;
            }
        }

        if (treasureCount == 0) {
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
