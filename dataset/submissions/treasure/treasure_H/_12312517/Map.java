import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    ArrayList<Treasure> treasureList = new ArrayList<>();
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.isActive = true;
        for (int i = 0; i < treasures.length; i++) {
            treasureList.add(treasures[i]);
        }
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasureList.size(); i++) {
            Treasure t = treasureList.get(i);
            if (t.getPosition().equals(position)) {
                return treasureList.get(i).getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasureList.size(); i++) {
            Treasure t = treasureList.get(i);
            if (t.getPosition().equals(position)) {
                treasureList.remove(t);
                break;
            }
        }
        if (treasureList.isEmpty()) {
            isActive = false;
        }

    }

    public boolean isActive() {
        if (treasureList.isEmpty())
        {
            return false;
        }else return true;
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
}
