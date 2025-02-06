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
    public  boolean isWithinBounds(Position p) {
        if (p.getRow()<0||p.getRow()>=rows||p.getCol()<0||p.getCol()>=columns) return false;
        return true;
    }
    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure!=null&&treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }
    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]!=null&&treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
                break;
            }
        }
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                return;
            }
        }
        this.isActive = false;
    }

    public boolean isActive() {
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                return this.isActive;
            }
        }
        this.isActive = false;
        return this.isActive;
    }
}
