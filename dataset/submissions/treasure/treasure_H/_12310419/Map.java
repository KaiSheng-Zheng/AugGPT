import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    private ArrayList<Treasure> newTreasure=new ArrayList<>();
    private int nowTreasure;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        newTreasure.addAll(Arrays.asList(treasures));
        setNowTreasure(newTreasure.size());
        nowTreasure=treasures.length;
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

    public ArrayList<Treasure> getNewTreasure() {
        return newTreasure;
    }

    public void setNewTreasure(ArrayList<Treasure> newTreasure) {
        this.newTreasure = newTreasure;
    }

    public int getNowTreasure() {
        return nowTreasure;
    }

    public void setNowTreasure(int nowTreasure) {
        this.nowTreasure = nowTreasure;
    }

    public int hasTreasure(Position position){
        for (Treasure treasure : newTreasure) {
            if (position.getCol() == treasure.getPosition().getCol() && position.getRow()==treasure.getPosition().getRow()) {
                return treasure.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        if (hasTreasure(position)!=0){
            for (int i = 0; i <treasures.length ; i++) {
                if (treasures[i].getPosition().getCol()==position.getCol()&&treasures[i].getPosition().getRow()==position.getRow()){
                    newTreasure.remove(treasures[i]);
                    nowTreasure--;
                }
            }
        }
    }
    public boolean isActive(){
        return nowTreasure > 0;
    }
}
