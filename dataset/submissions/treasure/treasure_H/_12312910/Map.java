public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    int counter;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.counter = treasures.length;
        this.isActive = true;
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int hasTreasure(Position position) {
        if (this.counter > 0) {
            int temp = 0;
            for (int i = 0; i < this.counter; i++) {
                if (position.getRow() == treasures[i].getPosition().getRow() && position.getCol() == treasures[i].getPosition().getCol()) {
                    temp += treasures[i].getScore();
                }
            }
            return temp;
        } else {
            return 0;
        }
    }

    public void update(Position position) {
        if (this.counter > 0) {
            for (int i = 0; i < this.counter; i++) {
                if (position.getRow() == treasures[i].getPosition().getRow() && position.getCol() == treasures[i].getPosition().getCol()) {
                    for (int j = i; j < this.treasures.length - 1; j++) {
                        this.treasures[j] = new Treasure(this.treasures[j + 1].getScore(), this.treasures[j + 1].getPosition());
                    }
                    treasures[this.treasures.length - 1] = new Treasure(0, new Position(0, 0));
                    this.counter--;
                    i--;
                }
                if (this.counter <= 0) {
                    this.isActive = false;
                }
            }
        } else {
            this.isActive = false;
        }
    }

    public boolean isActive() {
        if (this.counter > 0) {
            return true;
        } else {
            return false;
        }
    }
}