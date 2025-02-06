

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
        String str = String.format("(%d,%d)", x, y);
        return str;
    }
    
    public boolean equals(ChessboardPoint point) {
        if (this.getX() == point.getX() && this.getY() == point.getY()) {
            return true;
        }else {
            return false;
        }
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (isOnBoard(x+dx, y+dy)) {
            ChessboardPoint newPoint = new ChessboardPoint(x+dx, y+dy);
            return newPoint;
        }else {
            return null;
        }
    }

    public boolean isOnBoard(int x, int y) {
        if (0 <= x && x <= 7 && 0 <= y && y <= 7) {
            return true;
        }else {
            return false;
        }
    }
}

