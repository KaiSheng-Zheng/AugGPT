public class ChessboardPoint {
    private int x;
    private int y;
    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("(");
        stb.append(String.valueOf(getX()));
        stb.append(",");
        stb.append(String.valueOf(getY()));
        stb.append(")");
        return stb.toString();
    }
    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x1 = getX() + dx;
        int y1 = getY() + dy;
        if(0 <= x1 && x1 < 8 && 0 <= y1 && y1 < 8) {
            ChessboardPoint p1 = new ChessboardPoint(x1, y1);
            return p1;
        }else{
            return null;
        }
    }
}
