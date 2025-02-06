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
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPos().equals(pos)) {
                treasures[i] = null;
            }
        }
        if (remainingTreasures() == 0) {
            isActive = false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    private int remainingTreasures() {
        int count = 0;
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                count++;
            }
        }
        return count;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
