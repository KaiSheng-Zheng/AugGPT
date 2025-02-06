public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;


    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;  this.columns = columns;
        this.treasures = treasures;
    }




    public int hasTreasure(Position position) {
        int values = 0;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition().equals(position)) {
                values=treasures[i].getScore();
                treasures[i]=new Treasure(0,position);
            }else {
            }
        }return values;

    }

    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getPosition()==position){
                treasures[i].setScore(0);
            }
        }
    }
    public boolean isActive(){
         isActive = false;
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getScore()==0){

            }else {
               isActive = true;
                break;
            }
        }return isActive;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
class Map1 extends Map{
public Map1(int rows,int columns,Treasure[] treasures){
    super(rows,columns,treasures);
}
}
