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
        String s = "";
        s = s.concat("(").concat(String.valueOf(getX())).concat(",")
                .concat(String.valueOf(getY())).concat(")");
        return s;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        boolean b;
        b = this.x + dx >= 0 && this.x + dx <= 7 && this.y + dy >= 0 && this.y + dy <= 7;
        if (b){
            return new ChessboardPoint(this.x + dx, this.y + dy);
        }else {
            return null;
        }
    }
}
