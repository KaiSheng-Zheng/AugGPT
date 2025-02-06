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
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");
        return sb.toString();
    }


    public ChessboardPoint offset(int dx, int dy) {
        int x_ = x + dx;
        int y_ = y + dy;
        if (x_ >= 0 && x_ <= 7 && y_ >= 0 && y_ <= 7) {
            return new ChessboardPoint(x_,y_);
        }else {
            return null;
        }
    }
}
