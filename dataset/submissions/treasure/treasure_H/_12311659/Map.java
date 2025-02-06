public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int[] treasurescore;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.treasurescore = new int[treasures.length];
        this.isActive=true;
        for (int i = 0; i < treasures.length; i++) {
            treasurescore[i] = treasures[i].getScore();
        }
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }


    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (isActive) {
                if (position.equals(treasures[i].getPosition()) && treasurescore[i] != 0) {
                    treasurescore[i] = 0;
                    treasures[i].setFind(true);
                }
            }
        }
    }

    public boolean isActive() {
        for (int j = 0; j < treasurescore.length; j++) {
            if (treasurescore[j] != 0) {
                return true;
            }
        }
        return false;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
