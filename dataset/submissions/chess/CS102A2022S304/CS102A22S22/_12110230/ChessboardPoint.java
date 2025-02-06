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
    public String toString()
    {
        return String.format("(%d,%d)",getX(),getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy)
    {
        int fin_x=dx+x;
        int fin_y=dy+y;
        if(fin_x<=7 && fin_x>=0 && fin_y<=7 && fin_y>=0)
        {
            ChessboardPoint output=new ChessboardPoint(fin_x,fin_y);
            return output;
        }
        else
        {
           return null;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX() > o.getX())
        {
            return 1;
        }else if(this.getX() < o.getX())
        {
            return -1;
        }
        if(this.getY()>o.getY())
        {
            return 1;
        }else if(this.getY()<o.getY())
        {
            return -1;
        }
        return 0;
    }
}