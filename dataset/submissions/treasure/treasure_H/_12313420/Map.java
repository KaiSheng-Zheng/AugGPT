import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = true;
    private Treasure[] treasures;
    private ArrayList<Treasure> removeTreasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        removeTreasures = new ArrayList<>();
    }

    public int hasTreasure(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                boolean judge = true;
                for (int j = 0; j < removeTreasures.size(); j++) {
                    if (treasures[i].getPosition().equals(removeTreasures.get(j).getPosition())) {
                        judge = false;
                    }
                }
                if (judge == true) {
                    return treasures[i].getScore();
                }
            }
        }
        return 0;
    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                boolean judge = true;
                for (int j = 0; j < removeTreasures.size(); j++) {
                    if (treasures[i].getPosition().equals(removeTreasures.get(j).getPosition())) {
                        judge = false;
                    }
                }
                if (judge == true) {
                    removeTreasures.add(treasures[i]);
                }
            }
        }
        if (removeTreasures.size() == treasures.length) {
            isActive = false;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
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
