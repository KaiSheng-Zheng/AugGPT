public class ChessboardPoint {
    private int x;
    private int y;
    //ChessComponent currentPiece;

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
        return "("+this.getX()+","+this.getY()+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if(validMove(new ChessboardPoint(x+dx,y+dy))){
            return new ChessboardPoint(this.getX()+dx,this.getY()+dy);
        }
        else return null;
    }

    private boolean validMove(ChessboardPoint destination) {
        if(destination.getX()<8&&destination.getX()>=0&&destination.getY()<8&&destination.getY()>=0&&destination.getX()!=x&&destination.getY()!=y)
            return true;
        else
            return false;

    }
}
