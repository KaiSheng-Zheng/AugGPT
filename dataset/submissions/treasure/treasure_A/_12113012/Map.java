public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                Treasure updateScore = new Treasure(0, treasures[i].getPosition());
                treasures[i] = updateScore;
            }
        }
    }

    public boolean isActive() {
        for (Treasure treasure : treasures) {
            if (treasure.getScore() != 0) {
                return true;
            }
        }
        return false;
    }
}
