public class Map {
    private int cnt=0,INF=0x3f3f3f3f;
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows-1;
        this.columns=columns-1;
        this.treasures=treasures;
        this.isActive=true;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++)
            if(treasures[i].getPosition().equals(position)
                &&treasures[i].getScore()!=INF){
                return treasures[i].getScore();
            }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++)
            if(treasures[i].getPosition().equals(position)
                    &&treasures[i].getScore()!=INF){
                treasures[i].clr();++cnt;
                if(cnt==treasures.length)isActive=false;
            }
    }
    public int getRows() {return rows;}
    public int getColumns() {return columns;}
    public boolean isActive() {return isActive;}
}
