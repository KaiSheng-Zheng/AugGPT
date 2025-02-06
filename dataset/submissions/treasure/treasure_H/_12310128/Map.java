public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;

    private int count;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        count = treasures.length;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().getRow() == position.getRow() && treasure.getPosition().getCol() == position.getCol()) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        if (count > 0) {
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i].getPosition().getRow() == position.getRow() && treasures[i].getPosition().getCol() == position.getCol()) {
                    if (treasures[i].getScore() != 0) {
                        count--;
                        if (count == 0) {
                            isActive = false;
                        }
                    }
                    treasures[i] = new Treasure(0, treasures[i].getPosition());
                }
            }
        }
    }
}
