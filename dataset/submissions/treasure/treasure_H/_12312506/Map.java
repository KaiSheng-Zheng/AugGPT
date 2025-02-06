
public class Map {
    private boolean isActive;
    private Treasure[] treasures;
    private int rows;
    private int columns;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = treasures.length > 0;

    }

    public static Treasure[] remove(Treasure[] treasures, int index) {
        Treasure[] newTreasures = new Treasure[treasures.length - 1];
        if (index >= 0) System.arraycopy(treasures, 0, newTreasures, 0, index);
        if (newTreasures.length - index >= 0)
            System.arraycopy(treasures, index + 1, newTreasures, index, newTreasures.length - index);
        return newTreasures;
    }

    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure.position().equals(position)) {
                return treasure.score();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            {
                if (treasures[i].position().equals(position)) {
                    this.treasures = remove(treasures, i);
                }
            }
        }
        if (treasures.length == 0) isActive = false;
    }

    public boolean isValidPosition(Position position) {
        return position.getCol() >= 0 && position.getRow() >= 0 && position.getCol() < columns && position.getRow() < rows;
    }

    public boolean isActive() {
        return this.isActive;
    }
}
