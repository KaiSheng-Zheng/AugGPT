public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;

    int foundNum = 0;
    boolean[][] notFoundTreasure;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        notFoundTreasure = new boolean[rows][columns];
        for (int i = 0; i < treasures.length; i++) {
            notFoundTreasure[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = true;
        }
    }

    public int getRows() {
        return rows;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i <treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && notFoundTreasure[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)  && notFoundTreasure[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]) {
                notFoundTreasure[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = false;
                foundNum++;
            }
        }
        if (foundNum == treasures.length) {
            isActive = false;
        }
    }
}
