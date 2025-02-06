public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int numOfTre;
    int[][] treMap;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        treMap=new int[this.rows+3][this.columns+3];
        numOfTre=treasures.length;
        for(int i=0;i<numOfTre;i++){
            treMap[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]=treasures[i].getScore();
        }
        isActive=true;
    }
    public int hasTreasure(Position position){
        return treMap[position.getRow()][position.getCol()];
    }
    public void update(Position position){
        numOfTre--;
        treMap[position.getRow()][position.getCol()]=0;
        if(numOfTre==0){
            isActive=false;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
