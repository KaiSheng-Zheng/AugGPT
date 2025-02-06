public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private final Treasure[] treasures;

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        this.isActive = true;
    }

    //todo
    public int hasTreasure(Position pos) {
        for (Treasure t:
             this.treasures) {
            if(t.getPosition().equals(pos)&&t.getScore() > 0) return t.getScore();
        }
        return 0;
    }

    //todo
    public void update(Position pos){
        boolean isUpdate = false;
        for (Treasure t :
             this.treasures) {
            if(t.getPosition().equals(pos)) {
                t.setScore(0);
                isUpdate = true;
                break;
            }
        }
        if(isUpdate) {
            for (Treasure t :
                    this.treasures) {
                if(t.getScore() > 0) return;
            }
            this.isActive = false;
        }
    }
}
