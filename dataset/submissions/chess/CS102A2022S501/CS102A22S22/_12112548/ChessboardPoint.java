public class ChessboardPoint {
    private int x, y;

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

    public String toString() {
        return "("+x + ","+y+")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ChessboardPoint offset(int dx, int dy){//ass5
        ChessboardPoint newPoint = new ChessboardPoint(dx,dy);
        if (x + dx <= 7 && x + dx >= 0 && y + dy <= 7 && y + dy >= 0){
            newPoint.x = x + dx;
            newPoint.y = y + dy;
            return newPoint;
        }
        else {
            return null;
        }
    }
}
