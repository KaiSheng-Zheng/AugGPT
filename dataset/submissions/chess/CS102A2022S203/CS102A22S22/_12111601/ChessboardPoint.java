public class ChessboardPoint {
    private int x;
    private int y;
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

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString(){
        return "("+x+','+y+')';
    }
    public ChessboardPoint offset(int dx, int dy){
        if(x+dx<0||x+dx>7||y+dy<0||y+dy>7)return null;
        else return new ChessboardPoint(x+dx,y+dy);
    }
}
