import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive = false;
    private Treasure[] treasures;
    private ArrayList<Treasure> storeTreasures;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
        storeTreasures = new ArrayList<>();
        for (Treasure t:treasures
             ) {
            storeTreasures.add(t);
        }
    }

    public int hasTreasure(Position position){
        int scores = 0;
        for (int i = 0; i < storeTreasures.size(); i++) {
            if (position.equals(storeTreasures.get(i).getPos())){
                scores = storeTreasures.get(i).getScore();
            }
        }
        return scores;
    }

    public void update(Position position){
        for (int i = 0; i < storeTreasures.size(); i++) {
            if (position.equals(storeTreasures.get(i).getPos())){
                storeTreasures.remove(storeTreasures.get(i));
                break;
            }
        }
        if (storeTreasures.isEmpty()){
            isActive = false;
        }
    }

    public boolean isActive(){
        return this.isActive;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public ArrayList<Treasure> getStoreTreasures() {
        return storeTreasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}