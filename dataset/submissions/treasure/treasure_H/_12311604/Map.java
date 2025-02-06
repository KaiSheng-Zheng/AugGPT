public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    static  int co=0;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){

        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().getCol()==position.getCol()&&treasures[i].getPosition().getRow()==position.getRow()){return treasures[i].getScore();}
        }
        return 0; }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().getCol()==position.getCol()&&treasures[i].getPosition().getRow()==position.getRow()){
                treasures[i].setScore(0);
            }
        }
    }
    public boolean isActive() {
        int sc = 0;
        for (int i = 0; i < treasures.length; i++) {
            sc += treasures[i].getScore();
        }
        if (sc == 0) {
            return false;
        } else {
            return true;
        }
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
}
