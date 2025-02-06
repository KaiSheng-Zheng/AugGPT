public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive=true;
    }
    public int hasTreasure(Position position){
        int t=0;
        for (Treasure a:treasures){
            Position p=position;
            if (a.getPosition().getRow()==p.getRow()&&a.getPosition().getCol()==p.getCol()&&a.getScore()!=0){
                t=a.getScore();
            }
        }
        return t;
    }
    public void update(Position position){
        for (int i=0;i<treasures.length;i++){
            Position p=position;
            if (treasures[i].getPosition().getRow()==p.getRow()&&treasures[i].getPosition().getCol()==p.getCol()){
                treasures[i].setScore(0);
            }
        }
        boolean flag=false;
        for (Treasure a:treasures){
            if (a.getScore()!=0){
                flag=true;
            }
        }
        isActive=flag;

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
