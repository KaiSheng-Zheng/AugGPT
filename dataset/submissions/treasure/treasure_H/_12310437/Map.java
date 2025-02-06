import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasureArrayList;


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

    public ArrayList<Treasure> getTreasureArrayList() {
        return treasureArrayList;
    }

    public void setTreasureArrayList(ArrayList<Treasure> treasureArrayList) {
        this.treasureArrayList = treasureArrayList;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        if(treasures.length > 0){
            this.isActive = true;
        }else{
            this.isActive = false;
        }
        treasureArrayList = new ArrayList<>();
        for (int i = 0; i < treasures.length; i++) {
            treasureArrayList.add(i, treasures[i]);
        }
    }


    public int hasTreasure(Position position){
        for (int i = 0; i < treasureArrayList.size(); i++) {
            if(position.equals(treasureArrayList.get(i).getPosition())){
                return treasureArrayList.get(i).getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        Position p = new Position(-1, -1);
        Treasure remove = new Treasure(-1, p);
        for (int i = 0; i < treasureArrayList.size(); i++) {
            if(position.equals(treasureArrayList.get(i).getPosition())){
                remove = treasureArrayList.get(i);
            }
        }
        if(remove.getScore() != -1){
            treasureArrayList.remove(remove);
        }
        if(treasureArrayList.isEmpty()){
            setActive(false);
        }
    }
}
