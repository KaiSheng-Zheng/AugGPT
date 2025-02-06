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
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == null) {
                continue;
            }
            if (treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        int index = hasTreasure(position);
        if (index != 0) {
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i] == null) {
                    continue;
                }
                if (treasures[i].getPosition().equals(position)) {
                    treasures[i] = null;
                    break;
                }
            }
        }
    }

    public boolean isActive() {
        boolean check = true;
        for (Treasure treasure: treasures) {
            if (treasure != null) {
                check = false;
                break;
            }
        }
        if (check) {
            isActive = false;
            return false;
        }
        else return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        boolean check = true;
        for (Treasure treasure: treasures) {
            if (treasure != null) {
                check = false;
                break;
            }
        }
        if (check) {
            isActive = false;
            return null;
        } else return treasures;
    }
}
