
import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure>treat;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.treat=new ArrayList<>();
        for (int i = 0; i < treasures.length; i++) {
            treat.add(i,treasures[i]);
        }
    }
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
    public ArrayList<Treasure> getTreat() {
        return treat;
    }
    public int hasTreasure(Position position) {
        int a = 0;
        for (Treasure t : treat) {
            if (t.getPosition().equals(position)) {
                a =t.getScore();
            }
        }
        return a;
    }

    public void update(Position position) {
        treat.removeIf(t -> t.getPosition().equals(position));
    }

    public boolean isActive() {
        return !treat.isEmpty();
    }
}
