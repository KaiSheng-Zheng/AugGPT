public class Map{
    int rows;
    int columns;
    private static boolean isActive;
    private Treasure[] treasures;
    private static int unexplored;

    public Map(int rows, int columns, Treasure[] treasures) {
        this.rows = rows;
        this.columns = columns;
        this.treasures = treasures;
        unexplored = treasures.length;
        isActive = true;
    }
    public static boolean isActive() {
        isActive = unexplored != 0;
        return !isActive;
    }
    public int hasTreasure(Position position)
    {
        int a =0;
        for (Treasure treasure : treasures) {
            if (treasure.getPosition().getCol() == position.getCol() && treasure.getPosition().getRow() == position.getRow()) {
                update(treasure.getPosition());
                a = treasure.getScore();
            }
        }
        return a;
    }
    public void update(Position position)
    {
        position.setRow(-1);
        position.setCol(-1);
        if(unexplored>0)
        {
            unexplored--;
        }
        if(unexplored==0){isActive = false;}
    }
}
