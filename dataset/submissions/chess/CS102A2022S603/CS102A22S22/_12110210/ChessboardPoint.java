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

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%s,%s)",getX(),getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newx = getX()+dx;
        int newy = getY()+dy;
        if(newx<=7&&newx>=0&&newy<=7&&newy>=0){
            ChessboardPoint newpoint = new ChessboardPoint(newx,newy);
            return newpoint;
        }else{
            return null;
        }
    }
}
