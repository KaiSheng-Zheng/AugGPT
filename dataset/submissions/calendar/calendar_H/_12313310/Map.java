public class Map{
    private final int rows;
    private final int columns;
    private int[][][] smap=new int[900][900][3];
    private boolean isActive;
    private Treasure[] treasures;
    private int sum;
    private int num;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        num=0;
        sum=treasures.length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                smap[i][j][0]=0;
                smap[i][j][1]=0;
            }
        }
        for(int i=0;i<treasures.length;i++){
            smap[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()][0]=1;
            smap[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()][1]=treasures[i].getScore();
        }
    }
    public int hasTreasure(Position position){
        if(smap[position.getRow()][position.getCol()][0]==1){
            update(position);
            return smap[position.getRow()][position.getCol()][1];
        }
        else{
            return 0;
        }
    }
    public void update(Position position){
        smap[position.getRow()][position.getCol()][0]=0;
        num+=1;
    }
    public boolean isActive(){
        if(num<sum){
            return true;
        }
        else{
            return false;
        }
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
}