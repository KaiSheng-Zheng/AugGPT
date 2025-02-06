public class Map {
    // Fields
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[]treasures;

    // Constructor
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    // Methods
    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure != null){
                if (treasure.getPosition().equals(position)) {
                // consider the *null*
                        update(position);
                return treasure.getScore();}
            }
        }
        return 0; // Return 0 if no treasure is found at the position
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getPosition().equals(position)) {
                treasures[i] = null; // Remove the treasure
                break;
            }
        }
// Check if all treasures have been found
        boolean allFound = true;
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                allFound = false;
                break;
            }
        }
        if (allFound) {
            isActive = false; // Deactivate the map
        }
    }

    public boolean treasureExist(Position position){
        boolean Exist = false;
        for (int i = 0; i < treasures.length; i++)
            if (treasures[i] != null && treasures[i].getPosition().equals(position)) {
                Exist = true;
            }return Exist;
    }


        public int getRows() {
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public boolean getIsActive(){
        return isActive;
    }
    public Treasure[] getTreasures() {
        return treasures;
    }
    public boolean isActive() {
        return this.isActive;
    }
}


