public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    Treasure lastTreasure;
    public Map(int rows, int columns, Treasure[] treasures) {
        isActive = true;
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        int d = -1;
        int j = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                d = i;
                break;
            }
        }
        if (d != -1) {
            Treasure[] tempTreasures = new Treasure[treasures.length - 1];
            for (int i = 0; i < treasures.length; i++) {
                if (i == d) {
                    lastTreasure=treasures[d];
                } else {
                    tempTreasures[j++] = treasures[i];
                }
            }treasures = tempTreasures;
        }
        if (treasures.length==0){
            isActive=false;
        }
    }
}
