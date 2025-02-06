public class Map{
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
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                // Remove the found treasure
                treasures[i] = null;
                break;
            }
        }

        // Check if all treasures have been found
        boolean allTreasuresFound = true;
        for (Treasure treasure : treasures) {
            if (treasure != null) {
                allTreasuresFound = false;
                break;
            }
        }

        // Update the map's active status
        isActive = !allTreasuresFound;
    }

    /*
     * Getters
     */
    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

}
