public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    public int find = 0;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getFind() {
        return find;
    }

    public void setFind(int find) {
        this.find = find;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public int hasTreasure(Position position){
        int a = 0;
        for (int i =0;i<treasures.length;i++){
            if (position.equals(treasures[i].getPosition())){
                a = treasures[i].getScore();
                break;
            }
        }
        return a;
    }
    public void update(Position position){
        for (int i = 0;i<treasures.length;i++){
            if (treasures[i].getPosition().equals(position)){
                treasures[i] = new Treasure(0,new Position(-1,-1));
                break;
            }
            if (find == treasures.length){
                isActive = false;
            }
            else{
                isActive = true;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }
}
