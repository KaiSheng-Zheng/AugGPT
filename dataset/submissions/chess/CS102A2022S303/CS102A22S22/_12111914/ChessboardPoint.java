import java.util.List;

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
        String answer;
        answer = String.format("(" + this.x + "," + this.y + ")");
        return answer;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx > 7 || x + dx < 0 || y + dy > 7 || y + dy < 0 ) return null;
        else return new ChessboardPoint(x + dx,y + dy);
    }
    public boolean canMove(int dx, int dy){
        if (x + dx > 7 || x + dx < 0 || y + dy > 7 || y + dy < 0 ) return false;
        else return true;
    }

    public int compareTo(ChessboardPoint chessboardPoint) {
        if(this.getX() > chessboardPoint.getX() ||
                (this.getX() == chessboardPoint.getX() && this.getY() > chessboardPoint.getY()))
            return 1;
        else if(this.getX() == chessboardPoint.getX() && this.getY() == chessboardPoint.getY())
            return 0;
        else return -1;
    }

    public boolean contain(List<ChessboardPoint> chessboardPoints){
        for (int i = 0; i < chessboardPoints.size(); i++) {
            if (chessboardPoints.get(i).toString().equals(new ChessboardPoint(this.x, this.y).toString())) return true;
        }
        return false;
    }
}
