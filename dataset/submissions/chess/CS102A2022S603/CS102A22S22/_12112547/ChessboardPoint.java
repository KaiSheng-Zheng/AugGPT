public class ChessboardPoint implements Comparable<ChessboardPoint>{
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

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {   //by self
        this.y = y;
    }

    public void setX(int x) {   //by self
        this.x = x;
    }

    public String toString(){
        return "("+this.x+","+this.y+")" ;
    }

    public ChessboardPoint offset(int dx, int dy){
        if((dx + this.x) > 7 || (dy + this.y)> 7){
            return null;
        }else {
            return new ChessboardPoint(dx + this.x,dy + this.y);
        }
    }


    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX() == o.getX()){

            return new Integer(this.getY()).compareTo(o.getY());

        }

        return new Integer(this.getX()).compareTo(o.getX());
    }

}
