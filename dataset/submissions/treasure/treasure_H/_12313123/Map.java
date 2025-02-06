import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }
    public int hasTreasure(Position position){
        for(Treasure treasure:treasures){
            if(treasure.getPosition().equals(position)==true){
                return treasure.getScore();
            }

        }
        return 0;
    }
    public int hasTreasure(int row,int cal){
        Position position =new Position(row,cal);
        for(Treasure treasure:treasures){
            if(treasure.getPosition().equals(position)==true){
                return treasure.getScore();
            }

        }
        return 0;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void update(Position position){
        if (treasures.length!=0){
            for(int i=0;i<treasures.length;i++){
                if(treasures[i].getPosition().equals(position)){
                    ArrayList<Treasure> temp=new ArrayList<Treasure>();
                    for(Treasure a:treasures){
                    temp.add(a);
                    }
                    temp.remove(i);
                    treasures =new Treasure[treasures.length-1];
                    for(int k=0;k<treasures.length;k++){
                    treasures[k]=temp.get(k);
                    }

                }

            }
        }else isActive=false;

    }
    public void update(){
        if (treasures.length==0){
            isActive=false;
        }
    }
    public void update(int row,int cal){
       Position position=new Position(row,cal);
        if (treasures.length!=0){
            for(int i=0;i<treasures.length;i++){
                if(treasures[i].getPosition().equals(position)){
                    ArrayList<Treasure> temp=new ArrayList<Treasure>();
                    for(Treasure a:treasures){
                        temp.add(a);
                    }
                    temp.remove(i);
                    setTreasures(new Treasure[treasures.length-1]);
                    for(int k=0;k<treasures.length;k++){
                        treasures[k]=temp.get(k);
                    }

                }

            }
        }else isActive=false;
        update();

    }


}
