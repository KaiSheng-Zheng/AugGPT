public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public int[][] maps;
    public Map(int rows,int columns,Treasure[] treasures){
         this.rows=rows;
         this.columns=columns;
         this.treasures=treasures;
        maps = new int[rows][columns];
        for (int i = 0; i < treasures.length; i++) {
            maps[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()] = treasures[i].getScore();
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int hasTreasure(Position position){
        int a = 0;
        boolean b = false;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                a=i;
                b=true;
                break;
            }else {
                b=false;
            }
        }
        if (b){
            return treasures[a].getScore();
        }else return 0;

    }
    public void update(Position position){
        boolean flag= false;
        int length = treasures.length;
        for(int i = 0; i < length; i++) {
            if(position == treasures[i].getPosition()) {
                for(int j = i; j < length - 1; j++) {
                    treasures[j] = treasures[j + 1];
                }
                length--;
                flag = true;
                break;
            }
        }

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


}
