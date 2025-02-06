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
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(getX());
        stringBuilder.append(",");
        stringBuilder.append(getY());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */

    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        if (chessboardPoint.getX()+dx>7||chessboardPoint.getY()+dy>7||
                chessboardPoint.getX()+dx<0||chessboardPoint.getY()+dy<0){
            return null;
        }else{ chessboardPoint.x+=dx;
        chessboardPoint.y+=dy;
        return chessboardPoint;}//dont return "this"!}
    }
}
