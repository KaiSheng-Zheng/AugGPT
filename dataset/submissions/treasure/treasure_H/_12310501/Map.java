import java.util.HashMap;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int numberOfTreasures;
    private HashMap<String, Integer> treasureHashMap = new HashMap<>();

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.numberOfTreasures = treasures.length;
        this.isActive = true;

        createTreasureHashMap();
    }

    public int hasTreasure(Position position){
        return this.treasureHashMap.getOrDefault(position.toString(), 0);
    }

    public void update(Position position){
        this.treasureHashMap.remove(position.toString());
        this.numberOfTreasures--;
        if(this.numberOfTreasures == 0){
            isActive = false;
        }
    }

    public boolean isActive(){
        return this.isActive;
    }

    public void createTreasureHashMap(){
        for(Treasure treasure : this.treasures){
            treasureHashMap.put(treasure.getPosition().toString(),treasure.getScore());
        }
    }

    public boolean isPositionInvalid(Position position, int moveRow, int moveCol){
        int nextRow = position.getRow() + moveRow;
        int nextCol = position.getCol() + moveCol;

        if(nextRow >= 0 && nextRow < this.rows && nextCol >= 0 && nextCol < this.columns){
            return false; //the position is valid, so "isPositionInvalid" is false
        }
        return true; //the position is invalid, so "isPositionInvalid" is true
    }
}
