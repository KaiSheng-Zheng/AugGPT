public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        isActive=true;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;++i)
            if(treasures[i].getPosition().equals(position))
                return treasures[i].getScore();
        return 0;
    }
    public void update(Position position){
        if(hasTreasure(position)==0)return;
        Treasure[] copy=new Treasure[treasures.length-1];int ct=-1;
        for(int i=0;i<treasures.length;++i){
            Treasure now=treasures[i];
            if(now.getPosition().equals(position)==false)
                copy[++ct]=now;
        }
        treasures=copy;
        if(treasures.length==0)
            isActive=false;
    }
    public boolean isActive(){return isActive;}
    public boolean isIn(Position position){
        int nr=position.getRow(),nc=position.getCol();
        if(nr<0||nr>=rows||nc<0||nc>=columns)return false;
        return true;
    }
}