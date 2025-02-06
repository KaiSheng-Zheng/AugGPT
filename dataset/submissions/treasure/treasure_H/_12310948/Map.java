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
        // We can assume that the rows and columns of the map and the positions 
        // of the treasures are all valid. In addition, one position can only 
        // have one treasure.
    }

    // GETTERS
    public final int getRows() {
        return rows;
    }
    public final int getCols() {
        return columns;
    }

    // METHODS
    public int hasTreasure(Position position) {

        for (int i = 0; i < treasures.length; i++) {

            if (position.equals(treasures[i].getPosition())) {
                return treasures[i].getScore();
            }

        }
        return 0;

    }

    // update feature so that it also counts the path of the directions
    public void update(Position position) {

        for (int i = 0; i < treasures.length; i++) {

            if (position.equals(treasures[i].getPosition())) {

                Treasure[] tempTreasures = new Treasure[treasures.length - 1];
                for (int j = 0; j < treasures.length; j++) {

                    if (j < i) {
                        tempTreasures[j] = treasures[j];
                    }
                    else if (j > i) {
                        tempTreasures[j - 1] = treasures[j];
                    }

                }
                this.treasures = tempTreasures;

            }

        } 
    }

    public boolean isActive() {
        if (this.treasures.length == 0) {
            this.isActive = false;
        }
        return isActive;
    }
    
}