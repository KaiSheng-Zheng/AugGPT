public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        ChessboardPoint chessboardPoint=new ChessboardPoint(this.x,this.y);

        return String.format("(%d,%d)",this.x,this.y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public ChessboardPoint  offset(int dx, int dy){
        int a=this.x+dx;
        int b=this.y+dy;
        if (a<0||a>7||b<0||b>7){return null;}
        else {return new ChessboardPoint(a,b);}
    }

    @Override
    public int compareTo(ChessboardPoint chessboardPoint){
        if (x-chessboardPoint.x!=0){
            int a=x-chessboardPoint.x;
            return a;
        }
        else {int b=y-chessboardPoint.y;
            return b;}
    }


}