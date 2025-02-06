public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
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

    public ChessboardPoint offset(int dx, int dy) {
        int X = x + dx;
        int Y = y + dy;
        ChessboardPoint location = new ChessboardPoint(X,Y);
        if ((X < 0 || X > 7) || (Y < 0 || Y > 7)) return null;
        else return location;
    }

}