public class Map {
    private final int rows;

    public int getColumns() {
        return columns;
    }

    private final int columns;

    public int getRows() {
        return rows;
    }

    private int num=0;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
    }
    public int hasTreasure(Position pos){
        for(int i=0;i<treasures.length;i++) {
            if (pos.equals(treasures[i].getPos())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position pos){
        Position p=new Position(-1,-1);
        for(int i=0;i<treasures.length;i++) {
            if (pos.equals(treasures[i].getPos())){
                treasures[i]=new Treasure(0,p);
                num++;
            }
        }
    }
    public boolean isActive(){
        if(num==treasures.length){
            return false;
        }
        return true;
    }



}
