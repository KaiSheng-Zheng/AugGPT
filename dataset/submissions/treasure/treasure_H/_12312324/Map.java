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

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position) {
        if (!isActive) {
            return 0;
        }
        for (Treasure treasure : treasures) {
            if (treasure!=null&&treasure.getPosition().equals(position)) {
                return treasure.getScore();
            }
        }
        return 0;
    }

    public boolean isActive(){
        return isActive;
    }

    public void update(Position position) {

        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i]!=null&&treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
                break;
            }
        }
        int j=0;
        int i;
        for ( i = 0; i < treasures.length; i++) {
            if (treasures[i]==null) {
                j++;
            }
        }
        if (j==treasures.length){
            isActive=false;
        }
    }
}