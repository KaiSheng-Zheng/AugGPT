import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    ArrayList<Treasure> treasure = new ArrayList<>();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive=true;
        for (Treasure t : treasures) {
            this.treasure.add(t);
        }
    }

    public int hasTreasure(Position pos) {
        for (Treasure t : treasure) {
            if (pos.equals(t.getPosition())) {
                return t.getScore();
            }
        }
        return 0;
    }

    public void update(Position pos) {
        for (int i = 0; i < treasure.size(); i++) {
            if (treasure.get(i).getPosition().equals(pos)) {
                treasure.remove(i);
                break;
            }
        } // Check if all treasures are found

        isActive = !treasure.isEmpty();
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }
}
