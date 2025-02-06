public class Map {
    private final int rows, columns;
    private boolean isActive;
    private final Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        isActive = true;
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure==null) continue;
            if (treasure.getPosition().equals(position)) return treasure.getScore();
        }
        return 0;
    }
    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]==null) continue;
            if (treasures[i].getPosition().equals(position)) treasures[i] = null;
        }
        checkActive();
    }
    private void checkActive(){
        boolean existTreasure = false;
        for (Treasure treasure : treasures)
            if (treasure != null) {
                existTreasure = true;
                break;
            }
        if (!existTreasure) isActive = false;
    }
    public boolean isActive() {
        return isActive;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }
}
