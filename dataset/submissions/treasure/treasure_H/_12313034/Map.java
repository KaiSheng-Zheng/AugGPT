public class Map {
    private  final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public Map(int rows,int columns,Treasure[]treasures){
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position position){
        int s = 0;
        for (Treasure treasure : this.treasures) {
            if (position.equals(treasure.getPosition()) && treasure.getSituation()) {
                s = treasure.getScore();
            }
        }
        return s;
    }

    public void update(Position position){
        for (Treasure treasure: this.treasures){
            if (position.equals(treasure.getPosition()))treasure.has();
        }
        int f = 0;
        for (Treasure treasure: this.treasures){
            if (treasure.getSituation()) {
                f = 1;
                break;
            }
        }
        if (f==0){
            this.isActive = false;
        }
    }

    public boolean isActive(){
        return this.isActive;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

}
