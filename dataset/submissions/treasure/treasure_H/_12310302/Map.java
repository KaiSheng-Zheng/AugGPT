import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> tr=new ArrayList<>();
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;this.columns=columns;this.treasures=treasures;
        for(int i=0;i<treasures.length;i++){
            tr.add(treasures[i]);
        }
        if(tr.isEmpty()) this.isActive=false;
        else this.isActive=true;
    }
    public int hasTreasure(Position pos){
        for(int i=0;i<tr.size();i++){
            if(pos.getRow()==tr.get(i).getPosition().getRow()&&pos.getCol()==tr.get(i).getPosition().getCol()){
                return tr.get(i).getScore();
            }
        }
        return 0;
    }
    public void update(Position pos){
        for(int i=0;i<tr.size();i++){
            if(pos.getRow()==tr.get(i).getPosition().getRow()&&pos.getCol()==tr.get(i).getPosition().getCol()){
                tr.remove(i);
            }
        }
        if(tr.isEmpty()) this.isActive=false;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public boolean isActive(){
        if(this.isActive){
            return true;
        }
        else {
            return false;
        }
    }
}
