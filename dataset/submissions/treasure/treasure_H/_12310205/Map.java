public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;
    public int[][] maps;
    public Map (int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        maps = new int[rows][columns];
        for (int i = 0; i < treasures.length; i++) {
            maps[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
        }
    }
    public int hasTreasure(Position position){
        return maps[position.getRow()][position.getCol()];
    }
    public boolean isActive(){
        boolean a = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (maps[i][j] != 0){a = true;}
            }
        }
        return a;
    }
    public void update(Position position){
        if (maps[position.getRow()][position.getCol()] != 0){
            maps[position.getRow()][position.getCol()] = 0;
        }
    }
    public int getColumns(){return this.columns;}
    public int getRows(){return this.rows;}
}