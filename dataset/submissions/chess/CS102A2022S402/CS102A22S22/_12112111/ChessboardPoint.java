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
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public String toString(){
        return String.format("(%d,%d)", x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        int newX = getX() + dx;
        int newY = getY() + dy;
        if (newX>7 || newX<0 || newY>7 ||newY <0){
            return null;
        }else {
            return new ChessboardPoint(newX, newY);
        }
    }
}
