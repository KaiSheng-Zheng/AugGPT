public class ChessboardPoint {
    private int x, y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ChessboardPoint offset(int dx,int dy){
        ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);
        if (chessboardPoint.getX()<=7&&chessboardPoint.getX()>=0&&chessboardPoint.getY()<=7&&chessboardPoint.getY()>=0){
            return chessboardPoint;
        }
        else return null;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
