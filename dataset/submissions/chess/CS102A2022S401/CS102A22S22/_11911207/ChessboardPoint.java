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
    public String toString(){
        return "("+x + ","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy){
        int newX = dx + this.x;
        int newY = dy + this.y;
        if (newX>=8||newY>=8){
            return null;
        }
        else if (newX<0||newY<0){
            return null;
        }
        else {
            return new ChessboardPoint(newX,newY);
        }
    }
}