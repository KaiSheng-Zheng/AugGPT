public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
  /*
  For an example, look at the chessboard below
  (Just an example for better understanding, not input format)

  x\y 0 1 2 3 4 5 6 7
   0  R N B Q K B N R
   1  P P P P P P P P
   2  _ _ _ _ _ _ _ _
   3  _ _ _ _ _ _ _ _
   4  _ _ _ _ _ _ _ _
   5  _ _ _ _ _ _ _ _
   6  p p p p p p p p
   7  r n b q k b n r
  */

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        String result = "("+x+","+y+")";
        return result;
    }
    public ChessboardPoint offset(int dx, int dy){
        int X= x + dx;
        int Y = y + dy;
        if(X<0||Y<0||X>7||Y>7) return null;
        else return new ChessboardPoint(X,Y);
    }
}
