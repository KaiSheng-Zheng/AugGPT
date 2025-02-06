import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public ArrayList<Treasure> treasures1=new ArrayList<>();

    public int j=0;
    ArrayList <Treasure>treasure2=new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        treasures1.addAll(Arrays.asList(treasures));
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures1.size(); i++) {
            if (treasures1.get(i).getPosition().equals(position) && treasures1.get(i).getScore() != 0)
                return treasures1.get(i).getScore();
        }
        return 0;
    }

    public void update(Position position) {ArrayList <Treasure>treasure2=new ArrayList<>();
        for(int i=0;i<treasures1.size();i++){
            if(position.equals(treasures1.get(i).getPosition())){

            }else {
                treasure2.add(treasures1.get(i));
            }
        }treasures1=treasure2;
    }

    public boolean isActive() {
        for (int i = 0; i < treasures1.size(); i++) {
            if (treasures1.get(i).getScore() != 0) return true;
        }
        return false;

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
