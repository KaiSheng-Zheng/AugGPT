import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.treasures = treasures;
        this.rows = rows;
        this.columns = columns;
//        int[][] map = new int[rows][columns];
//        for (int i = 0; i < treasures.length; i++) {
//            for (int j = 0; j < rows; j++) {
//                for (int k = 0; k < columns; k++) {
//                    if (j==treasures[i].getPosition().getRow()){
//                        if (k==treasures[i].getPosition().getCol()){
//                            map[j][k] = treasures[i].getScore();
//                        }
//                    }
//                }
//            }
//        }
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }
    public Treasure[] getTreasures(){
        return this.treasures;
    }
//    int m = 0;
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())&&treasures[i].isValid() ){
//                m++;
//                update(treasures[i].getPosition());
//                System.out.println("11 " + treasures[i].getScore());
//                System.out.println(treasures[i].isValid());
                return treasures[i].getScore();
            }
        }
        return 0;

    }
    public void update(Position position){
//        treasures[m].getScore()=null;
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition()) && treasures[i].isValid()){
                treasures[i].setValid(false);
            }
        }
        boolean tempActive = false;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].isValid()){
                tempActive=true;
            }
        }
        if (!tempActive) isActive = false;

    }
    public boolean isActive(){
        return isActive;
    }
}
