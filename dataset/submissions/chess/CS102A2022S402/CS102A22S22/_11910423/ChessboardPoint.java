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

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int finalX = x + dx;
        if (finalX < 0 || finalX > 7) {
            return null;
        }

        int finalY = y + dy;
        if (finalY < 0 || finalY > 7) {
            return null;
        }

        return new ChessboardPoint(finalX, finalY);
    }
}
