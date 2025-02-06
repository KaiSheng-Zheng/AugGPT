
public class ChessboardPoint {
    private int x;
    private int y;


    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private boolean onBoard(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }


    public ChessboardPoint offset(int dx, int dy) {
        if (this.x + dx <= 7 && this.x + dx >= 0 && this.y + dy <= 7 && this.y + dy >= 0) {
            return new ChessboardPoint(this.x+dx, this.y+dy);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ChessboardPoint p = (ChessboardPoint) o;
        return x == p.x && y == p.y;
    }
}
