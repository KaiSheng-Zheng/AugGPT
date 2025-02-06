

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int rows ;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }


    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;


    }

    public int hasTreasure(Position position){
        for (Treasure t:treasures) {
           if  (t.getPosition().equals(position)){
return  t.getScore();
        }

        }


   return 0; }



    public void update(Position position) {
        List<Treasure> updatedTreasures = new ArrayList<>();
        for (Treasure t : treasures) {
            if (!t.getPosition().equals(position)) {
                updatedTreasures.add(t);
            }
        }
        treasures = updatedTreasures.toArray(new Treasure[updatedTreasures.size()]);
    }



    public boolean isActive(){
        if (treasures.length==0){
            return false;


            }
       else {return true;}
        }
    }

