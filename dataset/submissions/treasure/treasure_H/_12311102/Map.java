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
        int score = 0;
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                score = treasure.getScore();
                break;
            }
        }
        return score;
    }
    public boolean isActive() {
        boolean isActive = true;
        for (Treasure treasure : treasures) {
            if (treasure.equals(null)) {
                isActive = false;
            }
        }
        return isActive;
    }
    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
}