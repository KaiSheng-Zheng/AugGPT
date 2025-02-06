public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    private int counter = 0;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = new Treasure[treasures.length];
        for (int i = 0; i < treasures.length; i++) {
            this.treasures[i] = treasures[i];
        }
        counter = treasures.length;
        this.isActive = true;
    }

    public int hasTreasure(Position position){
        int item = -1;
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())){
                item = i;
                break;
            }
        }
        if (item != -1 && treasures[item].getScore()!=0){
            return treasures[item].getScore();
        }else {
            return 0;
        }
    }

    public void update(Position position){
        int item = -1;
        for (int i = 0; i < treasures.length; i++) {
            if (position.equals(treasures[i].getPosition())){
                item = i;
            }
        }
        if (item != -1 && treasures[item].getScore()!=0){
            treasures[item] = new Treasure(0,treasures[item].getPosition());
            counter--;
        }
    }

    public boolean isActive(){
        if (counter > 0){
            return true;
        }else {
            this.isActive = false;
            return false;
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}