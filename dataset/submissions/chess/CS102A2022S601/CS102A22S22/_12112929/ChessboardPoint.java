public class ChessboardPoint {
    private int x;
    private int y;
    ChessColor chessColor;
    public ChessboardPoint(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint(ChessColor chessColor) {
        this.chessColor=chessColor;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int setX(int x) {
        this.x = x;
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public String toString() {

        return "("+x+","+y+")";

    }
    public ChessboardPoint offset(int dx,int dy){
        int x1=this.getX(),y1=this.getY();
        ChessboardPoint c1;
        if(this.getX()+dx<0||this.getX()+dx>7||this.getY()+dy<0||this.getY()+dy>7)
            return null;
        else
            x1+=dx;
        y1+=dy;
        c1=new ChessboardPoint(x1,y1);
        return c1;

    }
}
