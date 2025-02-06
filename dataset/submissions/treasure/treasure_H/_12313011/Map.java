import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasureList;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows =rows;
        this.columns = columns;
        this.treasures = treasures;
        treasureList = new ArrayList<>();
        treasureList.addAll(Arrays.asList(this.treasures));
        isActive = !treasureList.isEmpty();
    }
    public int hasTreasure(Position position){
        int Score = 0;
        for (Treasure treasure : treasureList) {
            if (position.equals(treasure.getPosition())) {
                Score = treasure.getScore();
                break;
            }
        }
        return Score;
    }
    public void update(Position position){
            for (int i = 0; i < treasureList.size(); i++) {
                if (position .equals( treasureList.get(i).getPosition())) {
                    treasureList.remove(i);
                    break;
                }
            }
    }
    public boolean isActive(){
        isActive = !treasureList.isEmpty();
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ArrayList<Treasure> getTreasureList() {
        return treasureList;
    }
}
