public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
    //constructors
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                // Remove the found treasure
                treasure.isFound = true;
                break;
            }
        }
    }
    public boolean isActive(){
        isActive = false;
        for (Treasure treasure : treasures) {
            if (!treasure.isFound) {
                isActive = true;
                break;
            }
        }
        return isActive;
    }
}