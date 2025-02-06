public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns,Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public int hasTreasure(Position position){
        int num;
        for (int i = 0; i < treasures.length; i++) {
            if (position.getCol()==treasures[i].getPosition().getCol() && position.getRow()==treasures[i].getPosition().getRow()){
                int backscore = treasures[i].getScore();
                return backscore;
            }
            else {
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.getCol()==treasures[i].getPosition().getCol() && position.getRow()==treasures[i].getPosition().getRow()){
                treasures[i].setScore(0);
            }
        }
    }

    public boolean isActive() {
        boolean ifactive = false;
        for (Treasure num3 : treasures){
            ifactive = false;
            if (num3.getScore() > 0){
                ifactive = true;
                break;
            }
        }
        if (ifactive){
            return  true;
        }
        else {
            return false;
        }
    }
}
