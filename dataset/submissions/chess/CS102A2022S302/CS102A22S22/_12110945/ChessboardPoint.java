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
    //add setter for two for second version
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    // end
    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);

    }
    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int finalX = x + dx;
        int finalY = y + dy;
        ChessboardPoint newChessboardPoint = new ChessboardPoint(0,0);
        newChessboardPoint.x =finalX;
        newChessboardPoint.y =finalY;
        if (finalX > 7||finalX < 0||finalY > 7||finalY < 0){
            return null;
        }else{
           return newChessboardPoint;
        }
    }
}
