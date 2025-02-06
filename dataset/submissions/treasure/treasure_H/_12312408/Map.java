import java.util.ArrayList;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private ArrayList<Treasure> treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = new ArrayList<>();
        for (Treasure treasure : treasures) {
            this.treasures.add(treasure);
        }
        this.isActive = true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position){
        for (Treasure treasure : treasures){
            if (treasure.getPosition().equals(position)){
                return treasure.getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        ArrayList<Treasure> treasuresToRemove = new ArrayList<>();
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                treasuresToRemove.add(treasure);
            }
        }
        treasures.removeAll(treasuresToRemove);
        checkMap();
    }

    public boolean isActive(){
        return isActive;
    }

    public void checkMap(){
        isActive = false;
        for (Treasure treasure : treasures){
            if (treasure != null){
                isActive = true;
                break;
            }
        }
    }
}
