public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        isActive = true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        int total=0;
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())){
                treasures[i].setScore(0);
            }
        }
        for (int i = 0; i < treasures.length; i++) {
            total+=treasures[i].getScore();
        }
        if (total==0){
            isActive=false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}