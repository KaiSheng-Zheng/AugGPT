public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
/*
For an example, look at the chessboard below
(Just an example for better understanding, not input format)
x\y 0 1 2 3 4 5 6 7
0 R N B Q K B N R
1 P P P P P P P P
2 _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _
5 _ _ _ _ _ _ _ _
6 p p p p p p p p
7 r n b q k b n r
*/

    public ChessboardPoint() {
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint point=new ChessboardPoint(x+dx,y+dy);
        if ((x+dx)>=0&&(x+dx)<=7&&(y+dy)>=0&&(y+dy)<=7) {
            return point;
        }else {
            return null;
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint chess = (ChessboardPoint) o;
        if (x != chess.x) return false;
        if (y != chess.y) return false;
        return true;
    }

}
