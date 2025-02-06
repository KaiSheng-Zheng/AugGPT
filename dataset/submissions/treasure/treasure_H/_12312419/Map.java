public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int[][] map0;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        map0=new int[rows][columns];
        isActive=true;
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map0[i][j]=0;
            }
        }
        for(int i=0;i<treasures.length;i++){
            map0[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]=treasures[i].getScore();
        }
    }
    public int hasTreasure(Position position){
        int ifscore;
       ifscore=map0[position.getRow()][position.getCol()];
        return ifscore;
    }
    public void update(Position position){
        map0[position.getRow()][position.getCol()]=0;
        int check=1;
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(map0[i][j]==0){
                    check*=1;
                }else {
                    check*=0;
                }
            }
        }
        if (check==1) isActive=false;
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

    public int[][] getMap() {
        return map0;
    }

    public void setMap(int t,int x,int y) {
        map0[x][y] = t;
    }
}
