public class ChessboardPoint {
    private int x = 0;
    private int y = 0;

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
        String position = new String();
        int x = this.getX();
        int y = this.getY();
        position = "("+x+","+y+")";
        return position;
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
        ChessboardPoint newPoint = new ChessboardPoint(newX,newY);
        if (newX<=7 && newX>=0 && newY>=0 && newY<=7){
            return newPoint;
        }
        else return null;
    }
}
