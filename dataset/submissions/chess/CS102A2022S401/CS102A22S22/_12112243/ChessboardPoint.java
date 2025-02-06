

public class ChessboardPoint {
    protected int x;
    protected int y;

    public ChessboardPoint(int x, int y) {
        this.x = x  ;
        this.y = y ;
    }

    public int getX(){return x ;}

    public int getY(){ return y ;}

    public String toString(){ return ("("+x+","+y+")"); }

    public ChessboardPoint offset(int dx , int dy){
        int a  = this.x + dx;
        int b  = this.y + dy;
        ChessboardPoint chessboardPoint = new ChessboardPoint(a,b);
        if(a <= 7 && a >= 0 && b <= 7 && b >=0 )
                return  chessboardPoint;
        else
            return null;
    }
}
