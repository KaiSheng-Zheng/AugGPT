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
        return "("+x + ","+y+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int X=this.getX()+dx;
        int Y=this.getY()+dy;
        if (0<=X&&X<=7&&0<=Y&&Y<=7){
            return new ChessboardPoint(X,Y);
        }
        return null;
    }
}