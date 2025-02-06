public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int num;
    private  boolean[] exist;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        isActive=true;
        num=treasures.length;
        exist=new boolean[num];
    }
    public int hasTreasure(Position position){
        int i;
        for(i=0;i<treasures.length;i++){
            if(!exist[i])
                if((treasures[i].getPosition()).equals(position)){
                    return treasures[i].getScore();
                }
        }
        return 0;
    }
    public int getTreasure(Position position){
        int i;
        for(i=0;i<treasures.length;i++){
            if(!exist[i])
            if((treasures[i].getPosition()).equals(position)){
                update(position);
                exist[i]=true;
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        num--;
        if(num==0){
            isActive=false;
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
}
