public enum Direction
{
    LEFT(0,-1,"LEFT"),
    RIGHT(0,1,"RIGHT"),
    UP(-1,0,"UP"),
    DOWN(1,0,"DOWN");
    private int xmove;
    private int ymove;
    private String name;
    private Direction(int xmove,int ymove,String name)
    {
        this.xmove = xmove;
        this.ymove = ymove;
        this.name = name;
    }
    public int getXmove()
    {
        return xmove;
    }
    public int getYmove()
    {
        return ymove;
    }
}
