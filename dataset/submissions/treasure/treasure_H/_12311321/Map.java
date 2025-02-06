
import java.util.ArrayList;
public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        isActive=true;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public int hasTreasure(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i]==null){
                continue;
            }else if(position.equals(treasures[i].getPosition())){
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(treasures[i]==null){
                continue;
            }
            if(position.equals(treasures[i].getPosition())){
                this.treasures[i]=null;
            }
        }
        int count=0;
        for(int i=0;i<treasures.length;i++) {
                if(treasures[i]==null){
                    count++;
            }
        }
        if(count==treasures.length){
            isActive=false;
        }
    }

    public boolean isActive() {
        return isActive;
    }
}
