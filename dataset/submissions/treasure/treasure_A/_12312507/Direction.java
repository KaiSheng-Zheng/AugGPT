public enum Direction {
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
    private final int dr,dc;
    private Direction(int _dr,int _dc){
        dr=_dr;
        dc=_dc;
    }
    public int getDr(){return dr;}
    public int getDc(){return dc;}
}