import java.util.ArrayList;
import java.util.Collections;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    ArrayList<Treasure> list=new ArrayList<>();
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        Collections.addAll(list, treasures);
    }
    public int hasTreasure(Position position) {
        int t=0;
        for (Treasure i : list) {
            if (i.getPosition().equals(position)) {
                t= i.getScore();
            }
        }return t;
    }

    public void update(Position position){
        for (Treasure i : list) {
            if (i.getPosition().equals(position)) {
                list.remove(i);
                break;
            }
        }
        if(list.isEmpty()){
            isActive=false;
        }
    }
    public boolean isActive(){
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
