public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;


    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows-1;
        this.columns = columns-1;
        this.treasures = treasures;
        isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        Treasure[] treasures_new = new Treasure[treasures.length-1];
        int j = 0;  //use to build up a new list
        for (int i = 0; i < treasures.length&&j<treasures_new.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
                i++;
            }
            treasures_new[j] = treasures[i];
            j++;
        }
        treasures = treasures_new;
        if(treasures.length==0) isActive = false;
    }
}
