public class ChessboardPoint {
    private int x;
    private int y;


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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
        String s1 = "(";
        String s2 = ")";
        String s3 = ",";
        String s = s1.concat(String.valueOf(this.x)).concat(s3).concat(String.valueOf(this.y).concat(s2));

        return s;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x = this.x + dx;
        int y = this.y + dy;
        ChessboardPoint res = new ChessboardPoint(x,y);
        if ((x < 0 | x > 7) || (y < 0 | y > 7)){
            return null;
        }else {
            return res;
        }




    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint chess = (ChessboardPoint) o;
        if (x != chess.x) return false;
        if (y != chess.y) return false;
        return true;
    }

}
