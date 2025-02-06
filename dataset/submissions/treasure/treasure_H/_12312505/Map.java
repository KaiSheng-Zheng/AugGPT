public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int total;
    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        total=treasures.length;
    }
    public int hasTreasure(Position position) {
        for (Treasure t:treasures) {
            if (t.isValid()&&t.getPosition().equals(position)) return t.getScore();
        }
        return 0;
    }
    public void update(Position position) {
        for (Treasure t:treasures) {
            if (t.isValid()&&t.getPosition().equals(position)) {
                t.setValid(false);total--;
                return ;
            }
        }
    }
    public boolean isActive() {
        return total!=0;
    }
    public Position moveByOne(Position position,Direction direction) {
        Position p = new Position(position.getRow()+direction.getRow(),
                        position.getCol()+direction.getCol());
        if (p.getRow()>=0&&p.getRow()<rows&&p.getCol()>=0&&p.getCol()<columns) return p;
        return null;
    }
}
