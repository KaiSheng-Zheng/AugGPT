public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        return "("+getX()+","+getY()+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (getX()+dx <=7 && getY()+dy <=7 && getX()+dx>=0 && getY()+dy>=0){
            ChessboardPoint newPoint = new ChessboardPoint(getX()+dx,getY()+dy);
            return newPoint;
        }else{
            return null;
        }
    }

    public boolean isInChessboard(int dx, int dy){
        if (getX()+dx <=7 && getY()+dy <=7 && getX()+dx>=0 && getY()+dy>=0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.getX()<o.getX()){
            return -1;
        }else if (this.getX()>o.getX()){
            return 1;
        }else {
            if (this.getY()<o.getY()){
                return -1;
            }else if (this.getY()>o.getY()){
                return 1;
            }
        }
        return 0;
    }
}

