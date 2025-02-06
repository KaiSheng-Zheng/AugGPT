public class Map {
    private final int rows;
    private final int columns;
    private Treasure[] treasures;
    private boolean[] update;
    private boolean isActive;

    public boolean isActive() {
        for (int i = 0; i < treasures.length; i++) {
            if (!update[i]) {
                isActive = true;
                return isActive;
            }
        }
        return isActive;
    }


    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.update = new boolean[treasures.length];
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position) && !update[i]) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                update[i] = true;
            }
        }
        for (int i = 0; i < treasures.length; i++) {
            if (!update[i]) {
                isActive = true;
                return;
            }
        }
        isActive = false;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
}
