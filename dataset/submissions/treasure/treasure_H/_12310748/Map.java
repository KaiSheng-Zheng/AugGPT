public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
            }
        }
        checkMapStatus();
    }

    private void checkMapStatus() {
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                return;
            }
        }
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
