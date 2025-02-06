public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position){
        int Return = 0;
        for(Treasure t: treasures){
            if(t.getPosition() == position)
                Return = t.getScore();
        }
        return Return;
    }
    public void update(Position position) {
        int check = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                treasures[i].setScore(0);
            }
            if (treasures[i].getScore() != 0) {
                isActive = true;
            }
            if (treasures[i].getScore() == 0) {
                check++;
            }
        }
        if (check == treasures.length) {
            isActive = false;
        }
    }
    public boolean isActive(){
        return isActive;
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
