import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Treasure> dtreasures=new ArrayList<Treasure>();
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        if(treasures.length>0){
            isActive=true;
        }
        else{
            isActive=false;
        }
        for(Treasure x:treasures){
            dtreasures.add(x);
        }
    }
    public int hasTreasure(Position position){
        for(Treasure x:dtreasures){
            if((x.getPosition().getCol()==position.getCol())&(x.getPosition().getRow()==position.getRow())){
                return x.getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<dtreasures.size();i++){
            if(dtreasures.get(i).getPosition().equals(position)){
                dtreasures.remove(i);
            }
        }
        if(dtreasures.size()==0){
            isActive=false;
        }
    }
    public boolean isActive(){
        return isActive;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public ArrayList<Treasure> getDtreasures(){
        return dtreasures;
    }
}
