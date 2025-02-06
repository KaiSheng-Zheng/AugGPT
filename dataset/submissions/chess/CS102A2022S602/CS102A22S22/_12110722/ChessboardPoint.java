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
        String format = String.format("(%d,%d)",getX(),getY());
        return format;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        boolean xjudge = dx>0?dx+getX()>7:dx+getX()<0;
        boolean yjudge = dy>0?dy+getY()>7:dy+getY()<0;
        if(xjudge|yjudge){
            return null;
        }else{
            ChessboardPoint point = new ChessboardPoint(getX()+dx,getY()+dy);
            return point;
        }
    }


}
