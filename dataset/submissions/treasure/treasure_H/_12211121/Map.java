
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    // Initialize a map with number of rows and columns specified by rows and columns, and place treasures on the map.
    // We can assume that the rows and columns of the map and the positions of the treasures are all valid. In addition, one position can only have one treasure.
    // After initialization, the map should be active, and its size can no longer be changed.
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (treasure == null) {
                continue;
            }
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }
    // If the treasure on position has been found by players, the map should be updated to remove this treasure.
    // The map is no longer active as soon as all teasures have been found.
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == null) {
                continue;
            }
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
                break;
            }
        }
        isActive = false;
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                isActive = true;
                break;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }


}
