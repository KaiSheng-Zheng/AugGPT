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


    public String toString() {
        return "("+x+","+y+")";
    }



    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint a1 = new ChessboardPoint(x + dx,y + dy);
        if( x + dx >=0 && x + dx  <= 7 && y + dy  >= 0 && y + dy <=7){
            return a1;
        }
        else{
            return null;
        }
    }
}
