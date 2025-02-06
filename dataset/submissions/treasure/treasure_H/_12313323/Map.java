public class Map {
    public static int heng=0;
    public static int shu=0;
    public int getRows() {
        return rows;
    }

    private final int rows;


    public int getColumns() {
        return columns;
    }

    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
       this.columns=columns;
       this.rows=rows;
       heng=rows-1;
       shu=columns-1;
       this.treasures=treasures;
       isActive=true;
        Treasure.xunBaoTu=new int [rows][columns];
        for(int i=0;i< treasures.length;i++){
            Treasure.xunBaoTu[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]=treasures[i].getScore();
        }
    }
    public int hasTreasure(Position position){
        return(Treasure.xunBaoTu[position.getRow()][position.getCol()]);
    }
    public void update(Position position){


                Treasure.xunBaoTu[position.getRow()][position.getCol()]=0;
    }
    public boolean isActive(){
        boolean isActive=false;
        int jiaHe=Treasure.xunBaoTu[0][0];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                jiaHe=jiaHe+Treasure.xunBaoTu[i][j];
               if(jiaHe==0){
                   isActive=false;
               }
               else{
                   isActive=true;
               }
            }
        }
        return isActive;
    }
    public static int counter=0;
    public static int number(){
        counter++;
        return  counter;
    }
}
