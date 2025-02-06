public class Map {
    private final int rows;
    private final int columns;

    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = treasures.length > 0;
    }


    public int hasTreasure(Position position) {
        for (Treasure treasure : treasures) {
            if (treasure!=null&&treasure.getposition().equals(position)) {
                int a =treasure.getScore();
                treasure=null;
                return a;
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getposition().equals(position)) {
                treasures[i] = null; // remove the treasure from the map
                break;
            }
        }
        if (isEmpty()) {
            isActive = false;
        }
    }

    public boolean isActive(){
        if (isActive){
            return true;
        }
        return false;
    }
    public boolean isEmpty() {
        for (Treasure treasure : treasures) {
            if (treasure!=null) {
                return false;
            }
        }
        return true;
    }

    public boolean getisActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}

