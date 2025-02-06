public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=treasures;
    }
    public int hasTreasure(Position position){
        int a=0;
        for (Treasure treasure : treasures) {
            if (position.equals(treasure.getPosition())) {
                a = treasure.getScore();
            }
        }
        return a;
    }
    public boolean isActive(){
        return isActive;
    }
    public int getCol() {
        return columns;
    }
    public int getRow() {
        return rows;
    }
    public void update(Position position){
        for(int i=0;i<treasures.length;i++){
            if(position.equals(treasures[i].getPosition())){
                treasures[i]= new Treasure(0, new Position(-1,-1));
                }
            }
        int sum = 0;
        for (Treasure treasure : treasures) {
            sum += treasure.getScore();
        }
            if (sum == 0) {
                isActive = false;
            }
    }
}
