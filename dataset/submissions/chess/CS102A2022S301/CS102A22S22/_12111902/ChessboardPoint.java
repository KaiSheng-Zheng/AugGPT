public class ChessboardPoint {
    private int x=-1; // x: Horizontal location of this chess
    private int y=-1; // y: Vertical location of this chess
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

        this.x=x;
        this.y=y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {


        return "(" +
                + getX() +
                "," + getY() +")"
                ;
    }

    public boolean onChessboard(){
        boolean b = (this.getY() >= 0) && (this.getY() <= 7) && (this.getX() >= 0) && (this.getX() <= 7);
        return b;
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint c=new ChessboardPoint(this.getX(),this.getY());

        c.setX(c.getX()+dx);
        c.setY(c.getY()+dy);

        if (c.onChessboard()){
            return c;
        }else {
            return null;
        }

    }

}
