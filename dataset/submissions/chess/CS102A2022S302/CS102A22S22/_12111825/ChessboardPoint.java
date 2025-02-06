public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
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
        return "(" + x + "," + y + ")";

    }

    public ChessboardPoint offset(int dx, int dy){
        int Newx = x + dx;
        int Newy = y + dy;
        if (Newx < 0 || Newx > 7 || Newy > 7 || Newx < 0){
            return null;
        }else{
            ChessboardPoint NewPoint = new ChessboardPoint(Newx,Newy);
            return NewPoint;
        }

    }

}