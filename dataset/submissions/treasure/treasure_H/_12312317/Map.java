import java.util.ArrayList;

public class Map {
//    Fields
    private final int rows;
    private final int columns;
    private boolean isActive;
    static int updateCounter = 0;
    private ArrayList<Treasure> treasures = new ArrayList<>();
//    Constructors
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < treasures.length; i++) {
            this.treasures.add(treasures[i]);
        }
        isActive = true;
    }

//    Methods
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.size()-updateCounter; i++) {
            if(position.getCol()==treasures.get(i).getPosition().getCol()&&position.getRow()==treasures.get(i).getPosition().getRow()){
                return  treasures.get(i).getScore();
            }
        }
        return 0;
    }

    public void update(Position position){
        for (int i = 0; i < treasures.size()-updateCounter; i++) {
            if(position.equals(treasures.get(i).getPosition())){
                treasures.remove(i);
            }
        }
        if(treasures.size() == 0){
            isActive = false;
        }
    }

    public boolean isActive(){
        isActive = true;
            if(treasures.size() == 0){
                isActive = false;
                return  isActive;
            }
        return  isActive;
    }


//    get,set

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
