

import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean isActive;
    private Treasure[] treasures;
    public int[] record;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.record=new int[treasures.length];
    }
    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())) {
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int j=0;j<record.length;j++){
            if(position.equals(treasures[j].getPosition())){
                record[j]=0;
                treasures[j].setScore(0);
            }
        }
    }
    public boolean isActive() {
        for (int i = 0; i < treasures.length; i++) {
                record[i]=treasures[i].getScore();
        }
        for(int i =0;i<record.length;i++){
            if(record[i]!=0){
                return true;
            }
        }
        return false;
    }
}
