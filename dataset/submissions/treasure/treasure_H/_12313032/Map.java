import java.util.ArrayList;

public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> treasuress=new ArrayList<>();
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        for (Treasure e:treasures) {
            treasuress.add(e);
        }
        this.isActive=true;
    }
    public int hasTreasure(Position position){
        boolean has=false;
        for (Treasure e:treasuress) {
            if (e.getPosition().equals(position)){
                has=true;
                return e.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (Treasure e:treasuress) {
            if (e.getPosition().equals(position)){
                treasuress.remove(e);
              break;
            }
        }
        if (treasuress.size()==0){
            isActive=false;
        }
    }
    public boolean isActive(){
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public ArrayList<Treasure> getTreasuress() {
        return treasuress;
    }
}
