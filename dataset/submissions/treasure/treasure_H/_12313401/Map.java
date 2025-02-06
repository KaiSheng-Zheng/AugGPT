import java.util.ArrayList;
import java.util.Arrays;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public ArrayList<Treasure> Arr;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int hasTreasure(Position position) {
        int s = 0;
        for (int i = 0; i < this.treasures.length; i++) {
            if (this.treasures[i].getPosition().equals(position)) {
                s = treasures[i].getScore();
            }
        }return s;
    }


    public void update(Position position) {
        ArrayList<Treasure> Arr= new ArrayList<>(Arrays.asList(treasures));
        for (int i = 0; i < Arr.size(); i++) {
            if (Arr.get(i) .getPosition().equals(position) ) {
                Arr.remove(i);
            }
        }treasures= Arr.toArray(new Treasure[Arr.size()]);
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

    public boolean isActive() {


        return treasures.length> 0;
    }


}
