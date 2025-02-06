public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    private int[] order;
    private int counter;
    public Map(int rows, int columns,Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures=treasures;
        order=new int[treasures.length];
    }

    public int getRows() {
        return rows-1;
    }

    public int getColumns() {
        return columns-1;
    }

    public int hasTreasure(Position position){
        for (int i=0;i<treasures.length;i++){
            if (position.equals(treasures[i].getPosition())&&treasures[i].getisActive()){
                if (checkOrder(i)) {
                    order[counter] = i;
                    counter++;
                }
                return treasures[i].getScore();
            }
        }
            return 0;
    }

    public void update(Position position){
        treasures[order[counter-1]].setActive(false);
    }

    public boolean checkOrder(int counter){
        for (int i=0;i< this.counter;i++){
            if (order[i]==counter){
                return false;
            }
        }
        return true;
    }

    public boolean isActive(){
        for (int i=0;i<treasures.length;i++){
            if (treasures[i].getisActive()){
                return true;
            }
        }
        return false;
    }
}
