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
            if (position.equals(treasures[i].getPosition())) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        int fast = 0;
        int slow = 0;
        for (fast = 0; fast < treasures.length; fast++) {
            if(!treasures[fast].getPosition().equals(position)){
                treasures[slow] = treasures[fast];
                slow++;
            }
        }
        Treasure[] newtreasures = new Treasure[slow];           //update the treasures
        for (int i = 0; i < slow; i++) {
            newtreasures[i] = treasures[i];
        }
        this.treasures = newtreasures;
        if (treasures.length == 0){                             //if treasures are all found out, the map will be inactive
            isActive = false;
        }
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
