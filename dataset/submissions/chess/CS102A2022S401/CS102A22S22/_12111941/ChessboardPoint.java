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

    public void setX(int x){this.x=x;}

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    public void setY(int y){this.y=y;}
    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        String str="("+x+","+y+")";
        return str;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newX=x+dx;
        int newY=y+dy;



        if (newX<0 || newX>7 || newY<0 || newY>7)
            return null;
        else{
            ChessboardPoint chessboardPoint=new ChessboardPoint(newX,newY);
            return chessboardPoint;
        }
    }
}
