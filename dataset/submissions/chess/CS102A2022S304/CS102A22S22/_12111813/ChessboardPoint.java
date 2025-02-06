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


    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
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
        StringBuilder cord = new StringBuilder("("+this.getX()+","+this.getY()+")");
        return String.valueOf(cord);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newX = this.getX()+dx;
        int newY = this.getY()+dy;
        if (newX>-1 && newX < 8 && newY >-1 && newY < 8) {
            ChessboardPoint newPoint = new ChessboardPoint(newX,newY);
            return newPoint;
        }
        return null;
    }

}
