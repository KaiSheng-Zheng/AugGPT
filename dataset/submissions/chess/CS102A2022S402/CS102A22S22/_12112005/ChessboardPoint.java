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
        StringBuilder output = new StringBuilder();
        output.append("(");
        output.append(this.x);
        output.append(",");
        output.append(this.y);
        output.append(")");
        return output.toString();
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int nx = this.x + dx;
        int ny = this.y + dy;
        if(nx<0 || nx>7){
            return null;
        }
        if(ny<0 || ny>7){
            return null;
        }
        return new ChessboardPoint(nx,ny);
    }
}
