import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position pos) {
        for (Treasure treasure : treasures) {
            if (treasure.getPos().equals(pos)) {
                return treasure.getScore();
            }
        }
        return 0;
    }
    public void update(Position pos){
        List<Treasure> updatedTreasures = new ArrayList<>();
        for (Treasure treasure : treasures) {
            if (!treasure.getPos().equals(pos)) {
                updatedTreasures.add(treasure);
            }
        }

        treasures = updatedTreasures.toArray(new Treasure[0]);
    }
    public boolean isActive(){
        if (treasures.length==0){
            return false;
        }
        return true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
