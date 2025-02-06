public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position){
        for (int i=1;i<=this.treasures.length;i++){
            if (this.treasures[i-1]==null){}
            else if (this.treasures[i-1].getPosition().getRow()==position.getRow()&&treasures[i-1].getPosition().getCol()==position.getCol())return treasures[i-1].getScore();
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (this.treasures[i]==null){}
            else if (this.treasures[i].getPosition().equals(position)) {
                this.treasures[i] = null;
                break;
            }
        }
        int a=0;
        for (int i=1;i<=this.treasures.length;i++){
            if (this.treasures[i-1]!=null){
                a=1;
                break;
            }
        }
        if (a==0)this.isActive=false;
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
}
