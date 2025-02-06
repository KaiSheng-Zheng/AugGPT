public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(0);
        stringBuilder.append("(");
        stringBuilder.append(getX());
        stringBuilder.append(",");
        stringBuilder.append(getY());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(x + dx, y + dy);
            return chessboardPoint;
        } else {
            return null;
        }
    }
}
