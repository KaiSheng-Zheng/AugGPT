public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        return String.format("(%d,%d)", x, y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint afterMove = new ChessboardPoint(x + dx, y + dy);
        if (afterMove.getX() > 7 || afterMove.getX() < 0 || afterMove.getY() < 0 || afterMove.getY() > 7) {
            return null;
        } else {

            return afterMove;
        }
    }

    //I defined
    @Override
    public int compareTo(ChessboardPoint o){
        if (this.getX()>o.getX()){
            return 1;
        }else if (this.getX()<o.getX()){
            return -1;
        }else {
            return this.getY() - o.getY();
        }
    }
}
