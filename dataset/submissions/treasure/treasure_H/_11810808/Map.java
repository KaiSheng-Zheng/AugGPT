public class Map {

    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        isActive = true;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int hasTreasure(Position position){
        int result = 0;
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().equals(position)) {
                result = treasure.getScore();
            }
        }
        return result;
    }

    public void update(Position position){
        if(treasures.length <= 1){
            treasures = new Treasure[0];
            isActive = false;
        }else {
            Treasure[] temp = new Treasure[treasures.length-1];
            for(int i=0; i<treasures.length-1; i++){
                if(treasures[i].getPosition().equals(position)) {
                    temp[i] = treasures[treasures.length-1];
                }else {
                    temp[i] = treasures[i];
                }
            }
            treasures = temp;
        }
    }

    public boolean isActive(){
        return isActive;
    }

}