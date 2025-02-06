import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private ArrayList<Treasure> treasures = new ArrayList<>();
    private boolean isActive=isActive();

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < treasures.length; i++) {
            this.treasures.add(treasures[i]);
        }
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.size(); i++) {
            if (position.getCol() == treasures.get(i).getPosition().getCol() && position.getRow() == treasures.get(i).getPosition().getRow()) {
                return treasures.get(i).getScore();
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.size(); i++) {
            if (position.getCol() == treasures.get(i).getPosition().getCol() && position.getRow() == treasures.get(i).getPosition().getRow()) {
                treasures.remove(i);
            }
        }
    }

    public boolean isActive() {
        if (treasures.isEmpty()) {
            isActive=false;
        } else isActive=true;
        return isActive;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
