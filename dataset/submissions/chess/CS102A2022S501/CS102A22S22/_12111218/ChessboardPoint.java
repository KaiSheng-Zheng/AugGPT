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

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx >= 0 && x + dx <= 7 && y + dy >= 0 && y + dy <= 7) {

            int a=x;
            int b=y;


            return new ChessboardPoint(a+=dx, b+=dy);
        } else {
            return null;
        }


    }
}