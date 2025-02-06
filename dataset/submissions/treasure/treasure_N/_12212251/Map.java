public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;

    public boolean isActive() {
        return isActive;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    public int hasTreasure(Position position) {
        for (Treasure t:
             this.treasures) {
            if(t.getPosition().equals(position)&&!t.isUsed()) return t.getScore();
        }
        return 0;
    }

    public void update(Position position){
        boolean isUpdate = false;
        for (Treasure t :
             this.treasures) {
            if(t.getPosition().equals(position)) {
                t.setisUsed();
                isUpdate = true;
                break;
            }
        }
        if(isUpdate) {
            for (Treasure t :
                    this.treasures) {
                if(!t.isUsed()) return;
            }
            this.isActive = false;
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
