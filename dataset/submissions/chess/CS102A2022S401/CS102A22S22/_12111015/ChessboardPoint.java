public class ChessboardPoint {
    private int x;
    private int y;
    private ChessColor color;
    private ChessboardPoint offset;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint(ChessColor color) {
        this.color = color;
    }

    public ChessboardPoint(ChessboardPoint offset) {this.offset = offset;}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessColor getColor() {
        return color;
    }

    public ChessboardPoint getOffset() {
        return offset;
    }

    public void setOffset(ChessboardPoint offset) {
        this.offset = offset;
    }

    public String toString() {
        int a = getX();
        int b = getY();
        StringBuffer haha = new StringBuffer();
        haha.append("(");
        haha.append(a);
        haha.append(",");
        haha.append(b);
        haha.append(")");
        String result = haha.toString();
        return result;
    }


    public ChessboardPoint offset(int dx, int dy) {
        int x1 = getX() + dx;
        int y1 = getY() + dy;
        ChessboardPoint result = new ChessboardPoint(x1, y1);
        if ((x1 < 0) || (x1 > 7)) {
            return null;
        }
        else if ((y1 < 0) || (y1 > 7)) {
            return null;
        }
        else {
            result.x = x1;
            result.y = y1;
            return result;
        }
    }
}
