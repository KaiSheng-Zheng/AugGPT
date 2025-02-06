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
        return "(" + x +","+ y +")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int OutputX = dx + this.x;
        int OutputY = dy + this.y;
        if (OutputX >= 0 && OutputX <= 7 && OutputY >= 0 && OutputY <= 7) {
            return new ChessboardPoint(OutputX,OutputY);
        }else{
            return null;
        }
    }
}