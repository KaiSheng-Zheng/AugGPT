public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        if(dx+x<8 && dx+x>=0 && dy+y<8 && dy+y>=0){
            return new ChessboardPoint(dx+x,dy+y);
        }
        else return null;
    }
}
