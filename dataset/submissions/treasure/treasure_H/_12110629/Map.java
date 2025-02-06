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

    public int hasTreasure(Position pos) {
        for (int i = 0; i < this.treasures.length; i++) {
            Position pos1 = treasures[i].getPos();
            if (pos.equals(pos1)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position pos) {
        for (int i = 0; i < this.treasures.length; i++) {
            Position pos1 = treasures[i].getPos();
            if (pos.equals(pos1)) {
                Treasure[] newArr = new Treasure[treasures.length - 1];
                for (int ii = 0, j = 0; i < treasures.length; i++) {
                    if (ii == i) {
                        continue;
                    }
                    newArr[j++] = treasures[i];
                }
                treasures = newArr;
            }
        }
    }

    public boolean isActive() {
        if (this.isActive) {
            return true;
        }
        return false;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
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
}
