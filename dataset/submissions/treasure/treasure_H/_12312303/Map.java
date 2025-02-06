import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private ArrayList<Treasure> treasures = new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        for(int i=0;i<treasures.length;i++){
            this.treasures.add(treasures[i]);
        }
    }

    public int hasTreasure(Position position) {
        for (Treasure i : treasures) {
            if (i.getPosition().equals(position)) {
                return i.getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (Treasure i : treasures) {
            if (i.getPosition().equals(position)) {
                treasures.remove(i);
                if (treasures.isEmpty())
                    isActive = false;
                return;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean b) {
        this.isActive = b;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
