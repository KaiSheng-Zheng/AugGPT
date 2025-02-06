import java.util.ArrayList;
public class Map {
    private final int rows;
    private final int columns;

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean isActive;
    private Treasure[] treasures;
    ArrayList<Treasure> a = new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = treasures.length > 0;
        for (int i = 0; i < treasures.length; i++) {
            a.add(treasures[i]);
        }
    }

    public int hasTreasure(Position position) {
        int jiascore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (position.equals(a.get(i).getPosition())) {
                jiascore = a.get(i).getScore();
            }
        }
        return jiascore;
    }

    public void update(Position position) {
        for (int i = 0; i <a.size() ; i++) {
            if (a.get(i).getPosition().equals(position)){
                a.remove(i);
            }
        }if(a.isEmpty()){
            isActive=false;
        }
    }
}
