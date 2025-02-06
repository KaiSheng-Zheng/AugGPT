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
        String a = String.valueOf(getX());
        String b = String.valueOf(getY());
        return "("+a+","+b+")" ;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int a = x + dx;
        int b = y + dy;
        ChessboardPoint newoffset = new ChessboardPoint(a,b);
        if (a <= 7 && a >= 0 && b<=7&&b>=0){
            return newoffset;
        } else return null;
    }

}
