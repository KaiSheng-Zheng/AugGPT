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

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().getCol()==position.getCol()&&treasure.getPosition().getRow()== position.getRow()) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().getCol()==position.getCol()&&treasure.getPosition().getRow()== position.getRow()) {
                removeTreasure(treasure);
                break;
            }
        }
        updateActiveState();
    }

    public boolean isActive() {
        return isActive;
    }

    private void removeTreasure(Treasure treasure) {
        Treasure[] updatedTreasures = new Treasure[treasures.length - 1];
        int index = 0;
        for (Treasure t : treasures) {
            if (!t.equals(treasure)) {
                updatedTreasures[index++] = t;
            }
        }
        treasures = updatedTreasures;
    }

    private void updateActiveState() {
        if (treasures.length == 0) {
            isActive = false;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}