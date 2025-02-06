

import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true ;
    int sum;
    private ArrayList<Treasure> treasures = new ArrayList<>();
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.isActive=true;
        sum=treasures.length;
        for(int i=0;i<sum;i++) {
            this.treasures.add(treasures[i]);
        }
    }
    public int hasTreasure(Position position){
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) return treasure.getScore();
        }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.size();i++)
                if(treasures.get(i).getPosition().equals(position)){
                    treasures.remove(i);
                    if(treasures.isEmpty()){
                        isActive = false;
                    }
                }
    }
    public boolean isActive(){
        return isActive;
    }
    public void setActive(boolean kk) {
        this.isActive = kk;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}