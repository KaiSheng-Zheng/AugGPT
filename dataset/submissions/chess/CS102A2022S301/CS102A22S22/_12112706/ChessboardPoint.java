
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

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (this.getX()+dx >= 0 && this.getX()+dx <= 7 && this.getY()+dy >= 0 && this.getY()+dy <= 7) {
            return new ChessboardPoint(this.getX()+dx, this.getY()+dy);
        } else return null;
    }

}