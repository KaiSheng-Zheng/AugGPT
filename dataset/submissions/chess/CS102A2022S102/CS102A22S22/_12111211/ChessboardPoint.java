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
        String coordinate = "("+getX()+","+getY()+")";
        return coordinate;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newX=dx+this.x;
        int newY=dy+this.y;
        if((newX>=0)&&(newX<=7)&&
                (newY>=0)&&(newY<=7)) {
            return new ChessboardPoint(newX, newY);
        }else {
            return null;
        }
    }
}
