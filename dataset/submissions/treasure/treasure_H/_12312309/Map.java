import java.util.ArrayList;
import java.util.Collections;

public class Map {
    private final int rows;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private final int columns;

    private boolean isActive;


    private ArrayList<Treasure> treasures = new ArrayList<>();

    private int treasureTimes;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        Collections.addAll(this.treasures,treasures);
        this.isActive = true;
        treasureTimes = treasures.length;
    }

    public int hasTreasure(Position position) {
        int sum = 0;
        int index = 0;
        for (int i = 0; i < treasures.size(); i++) {
            if (treasures.get(i).getPosition().getCol() == position.getCol() && treasures.get(i).getPosition().getRow() == position.getRow()) {
                sum++;
                index = i;
                break;
            }
        }

        if (sum != 0) {
            return treasures.get(index).getScore();
        } else {
            return 0;
        }

    }



    public void update(Position position) {

        for (int i = 0; i < treasures.size(); i++) {
            if (treasures.get(i).getPosition().getCol() == position.getCol() && treasures.get(i).getPosition().getRow() == position.getRow()) {
                Treasure blankTreasure = new Treasure(0,treasures.get(i).getPosition());
                treasures.set(i,blankTreasure);
                treasures.remove(treasures.get(i));
                treasureTimes--;
            }
        }

        if (treasureTimes == 0) {
            this.isActive = false;
        }

    }
}
