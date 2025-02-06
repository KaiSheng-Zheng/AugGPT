public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        int j = 0;
        int score = 0;
        for (Treasure treasure : treasures) {
            if (position == treasure.getPosition()) {
                score += treasure.getScore();
                j = 1;
            }
        }
        if (j == 1) {
            return score;
        } else {
            return 0;
        }
    }

    public void update(Position position) {
        if (treasures.length > 1) {
            Treasure[] oldTreasure = treasures.clone();
            Treasure[] newTreasure = new Treasure[treasures.length - 1];
            int j = 0;
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i].getPosition() == position) {
                    j += i;
                }
            }
            for (int k = 0; k < newTreasure.length; k++) {
                if (k < j) {
                    newTreasure[k] = oldTreasure[k];
                } else {
                    newTreasure[k] = oldTreasure[k + 1];
                }
            }treasures=newTreasure.clone();
        }else {
            this.isActive=false;
        }
    }
    public boolean isActive(){
        return this.isActive;
    }
}