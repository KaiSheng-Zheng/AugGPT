public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public static int n;
    public static int m;
    public static int[][] map;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        n = this.rows;
        m = this.columns;
        map = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int ii = 0;ii < m;ii++){
                map[i][ii] = 0;
            }
        }
        for(int i = 0;i < treasures.length;i++){
            int maprow = treasures[i].getPosition().getRow();
            int mapcol = treasures[i].getPosition().getCol();
            int mapscore = treasures[i].getScore();
            map[maprow][mapcol] = mapscore;
        }
    }
    public int hasTreasure(Position position){
        int treasurescore = map[position.getRow()][position.getCol()];
        return treasurescore;
    }
    public void update(Position position){
        map[position.getRow()][position.getCol()] = 0;
    }
    public boolean isActive(){
        isActive = true;
        int allscore = 0;
        for(int i = 0;i < n;i++){
            for(int ii = 0;ii < m;ii++){
                allscore = allscore + map[i][ii];
            }
        }
        if (allscore == 0){
            isActive = false;
        }
        return isActive;
    }
}