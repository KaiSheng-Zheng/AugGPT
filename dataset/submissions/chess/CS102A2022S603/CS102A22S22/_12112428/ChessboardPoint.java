/** add an interface */
public class ChessboardPoint implements Comparable{
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
        return "(" + x + "," + y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy){
        if(x + dx < 0 || x + dx > 7 || y + dx < 0 || y + dy > 7){
            return null;
        }
        return new ChessboardPoint(x + dx, y + dy);
    }

    @Override
    public int compareTo(Object o) {
        ChessboardPoint obj = (ChessboardPoint) o;
        if(x != obj.x) {
            return x - obj.x;
        }
        return y - obj.y;
    }

    /** add my method */
}
