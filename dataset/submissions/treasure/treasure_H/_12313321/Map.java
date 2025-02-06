public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public int[] tr;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows-1;
        this.columns=columns-1;
        this.treasures=treasures;
        this.isActive=true;
        this.tr=new int[treasures.length];
        for(int co=0;co<tr.length;co++){
            tr[co]=1;
        }
    }
    public int hasTreasure(Position position){
        for(int cou=0;cou<treasures.length;cou++)
            if(treasures[cou].getPosition().equals(position))
                return treasures[cou].getScore()*tr[cou];
        return 0;
    }
    public void update(Position position){
        if(hasTreasure(position)!=0){
            for(int cou=0;cou<treasures.length;cou++){
                if(treasures[cou].getPosition().equals(position)) {
                    tr[cou]=0;
                }
            }
        }
    }
    public boolean isActive(){
        for(int cou=0;cou<tr.length;cou++){
            if(this.tr[cou]==1)
                return true;
        }
        return false;
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

}