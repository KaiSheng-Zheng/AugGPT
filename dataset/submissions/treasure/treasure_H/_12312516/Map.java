import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> foundTreasures;
    private ArrayList<Boolean> isUpdated;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
        this.foundTreasures=new ArrayList<>();
        this.isUpdated=new ArrayList<>();
        if(treasures.length>0)isActive=true;
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < foundTreasures.size(); i++) {
            if(foundTreasures.get(i).getPosition().getCol()==position.getCol()&&foundTreasures.get(i).getPosition().getRow()==position.getRow()){
                if(isUpdated.get(i))return 0;
                else return foundTreasures.get(i).getScore();
            }
        }
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().getRow()==position.getRow()&&treasures[i].getPosition().getCol()==position.getCol()){
                foundTreasures.add(treasures[i]);
                isUpdated.add(false);
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < foundTreasures.size(); i++) {
            if (position.getCol()==foundTreasures.get(i).getPosition().getCol()&&position.getRow()==foundTreasures.get(i).getPosition().getRow()){
                isUpdated.set(i, true);
            }
        }
        int counter=0;
        for (int i = 0; i < isUpdated.size(); i++) {
            if(isUpdated.get(i))counter++;
        }
        if(counter==treasures.length)isActive=false;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getColumns() {
        return columns;
    }
    public int getRows(){
        return rows;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }
}
