import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasures01;


    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.treasures01 = new ArrayList<>(Arrays.asList(treasures));
    }

    public int hasTreasure(Position position) {
        for (Treasure t : treasures01) {
            if (t.getPosition().equals(position)) {
                return t.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        int m = -1;
        for (int i = 0; i < treasures01.size(); i++) {
            if (treasures01.get(i).getPosition().equals(position)) {
                m = i;
            }
        }
        if (m != -1) {
            treasures01.remove(treasures01.get(m));
        }
    }

    public boolean isActive() {
        return !treasures01.isEmpty();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
}
