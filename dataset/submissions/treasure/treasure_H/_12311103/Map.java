public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int treasureNumber;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasureNumber = treasures.length;
        this.treasures = new Treasure[treasures.length];
        for (int i = 0; i < treasures.length; i++) {
            this.treasures[i] = treasures[i];
        }
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.getRow() == treasures[i].getPosition().getRow() &&
                    position.getCol() == treasures[i].getPosition().getCol())
                return treasures[i].getScore();
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.getRow() == treasures[i].getPosition().getRow() &&
                    position.getCol() == treasures[i].getPosition().getCol() && treasures[i].getScore() != 0) {
                treasureNumber--;
                treasures[i].setScore(0);
            }
        }
    }

    public boolean isActive() {
        if (treasureNumber > 0)
            isActive = true;
        else isActive = false;
        return isActive;
    }

    public int getTreasureNumber() {
        return treasureNumber;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}