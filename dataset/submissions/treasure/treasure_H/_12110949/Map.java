import java.util.Arrays;
import java.util.Objects;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }
    public int hasTreasure(Position position){
        for(int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getPosition().equals(position)) {
                this.treasures[i] = null;
            }
        }
    }
    public boolean isActive(){
        if (Arrays.stream(treasures).allMatch(Objects::isNull)) {
            return false;
        }
        return isActive;
    }

    public int getColumns() {
        return columns;
    }
    public int getRows(){
        return rows;
    }

}
