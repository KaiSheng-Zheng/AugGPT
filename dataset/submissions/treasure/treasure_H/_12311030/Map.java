import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private ArrayList<Treasure> treasureArraylist;

    public ArrayList<Treasure> getTreasureArraylist() {
        return this.treasureArraylist;
    }

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasureArraylist=new ArrayList<>();
        for(int i=0;i<treasures.length;i++){
            treasureArraylist.add(treasures[i]);
        }
    }
    public int hasTreasure(Position position){
        for(int i=0;i< treasureArraylist.size();i++){
            if(treasureArraylist.get(i).getPosition().getCol()== position.getCol()
                    &&treasureArraylist.get(i).getPosition().getRow()== position.getRow()){
                return treasureArraylist.get(i).getScore();
            }
        }return 0;

    }public void update(Position position){

        for (int i=0;i<treasureArraylist.size();i++){
            if(treasureArraylist.get(i).getPosition().getCol()== position.getCol()
                    &&treasureArraylist.get(i).getPosition().getRow()== position.getRow()){

                treasureArraylist.remove(i);
                break;
        }

        }


    }public boolean isActive(){
       if(treasureArraylist.size()!=0) {
           return true;
       }else{
        return false;
       }
    }

}
