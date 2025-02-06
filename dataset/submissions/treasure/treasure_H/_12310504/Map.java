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
        isActive = Arrays.stream(this.treasures).anyMatch(Objects::nonNull);
    }
    public int hasTreasure(Position position){
            for (int i =0; i < treasures.length; i++){
                if (treasures[i] != null && treasures[i].getPosition().equals(position)){
                    return treasures[i].getScore();
                }

        }
            return 0;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void update (Position position){
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null && treasures[i].getPosition().equals(position)) {
                treasures[i] = null;
            }
        }
        isActive = Arrays.stream(treasures).anyMatch(Objects::nonNull);
    }
    public boolean isActive(){
        if (isActive){
            return true;
        }
        else{
            return false;
        }
    }

}
