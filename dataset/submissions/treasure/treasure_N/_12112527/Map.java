

import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive =true;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public  ArrayList<Treasure> getTreasures() {
        return treasures;
    }
    private ArrayList<Treasure> treasures = new ArrayList<>();

//    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures.addAll(Arrays.asList(treasures));
//        this.treasures.addAll(treasures);
    }
    public int hasTreasure(Position position){
        for (int i = 0;i<treasures.size();i++){
            if (treasures.get(i).getPosition().equals(position)){
                return treasures.get(i).getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.size(); i++) {
            if(treasures.get(i).getPosition().equals(position)){
                treasures.remove(i);
                if (treasures.isEmpty()){
                    this.isActive = false;
                    return;
                }
            }
        }
    }
    public boolean isActive() {
//        return !treasures.isEmpty();
        return this.isActive;
//        for (int i = 0; i < this.treasures; i++) {
//            if (getTreasures()[i].getScore() > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return false;
    }
}
