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
        return this.x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)",getX(),getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint ovo = new ChessboardPoint(x + dx,y + dy);
        if ((x + dx < 0 || x + dx > 7) || (y + dy < 0) || (y + dy >7)){
            return null;
        }else {return ovo;}

        }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
