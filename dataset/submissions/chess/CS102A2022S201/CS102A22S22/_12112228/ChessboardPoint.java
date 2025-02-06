public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y =y;
    }
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        String s = String.format("(%d,%d)",x,y);
        return s;
    }
    public ChessboardPoint offset(int dx, int dy){
            int  x_ = this.x+dx;
            int  y_ = this.y+dy;
            ChessboardPoint chessboardPoint = null;
            if(x_<=7&&x_>=0&&y_<=7&&y_>=0){
               chessboardPoint = new ChessboardPoint(x_,y_);
            }
            return chessboardPoint ;
    }
}
