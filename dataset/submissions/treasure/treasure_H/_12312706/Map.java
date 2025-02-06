public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int numOfTreasures;
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.numOfTreasures = treasures.length;
        this.isActive = true;
    }
    public int hasTreasure(Position position) {
        for (int i = 0; i < numOfTreasures; i++) {
            if (treasures[i].getPosition().equals(position)) return treasures[i].getScore();
        }
        return 0;
    }
    public void update(Position position) {
        for (int i = 0; i < numOfTreasures; i++) {
            if (treasures[i].getPosition().equals(position)) {
                for (int j = i; j < numOfTreasures - 1; j++) {
                    treasures[j] = treasures[j + 1];
                }
                numOfTreasures--;
                break;
            }
        }
        if (numOfTreasures == 0) this.isActive = false;
    }
    public boolean isActive() {
        return this.isActive;
    }
}
