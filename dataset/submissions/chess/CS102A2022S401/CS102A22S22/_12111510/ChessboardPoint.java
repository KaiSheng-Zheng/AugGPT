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
//    @Override
    public String toString(){
        String chessPlace = "(" + x + "," + y + ")" ;
        return chessPlace;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy){
        int a = x + dx;
        int b = y + dy;
        if (a>=0 && a<=7 && b>=0 && b<=7 ){
            return new ChessboardPoint(a,b);
        }else {
            return null;
        }
    }

    public boolean equals(Object o){
        if (o instanceof ChessboardPoint){
            if (((ChessboardPoint) o).getX()==x && ((ChessboardPoint) o).getY()==y){
                return true; 
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
