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
        if (x >= 0 && y >= 0){
            return String.format("(%d,%d)",x,y);
        }else {
            return null;
        }
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx >= 0 && x + dx <= 7 && y + dy >=0 && y + dy <= 7){
            ChessboardPoint New = new ChessboardPoint(dx + x,dy + y);
            return New;
        }else {
            return null;
        }
    }
}
