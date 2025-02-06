public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int [][] maps;

    public Map(int rows,int columns, Treasure[] treasures){
        this.rows  = rows;
        this.columns = columns;
        this.maps = new int[rows][columns];
        this.treasures = treasures;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                maps[i][j] = 0;
            }
        }
        for (int i = 0; i < treasures.length; i++) {
            maps[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
        }
        this.isActive = true;

    }

    public int[][] getMaps() {
        return maps;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }

    public int hasTreasure(Position position){
        return maps[position.getRow()][position.getCol()];
    }
    public void update( Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())){
                maps[position.getRow()][position.getCol()] = 0;

            }
        }
        if (judgingMap(maps))
            isActive = false;
    }
    public boolean judgingMap (int[][] maps){
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if(maps[i][j]!=0)
                    return false;
            }
        }
        return true;
    }

}