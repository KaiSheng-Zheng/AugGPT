import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;
    private ChessComponent[][] chessComponents;

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
        return String.format("(%d,%d)", x, y);
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
        if (x < 8 && y < 8 && x >= 0 && y >= 0 ) {
            if (Objects.equals(chessComponents[this.x][this.y].getChessColor(),chessComponents[x][y].getChessColor())){
                return null;
            }
            return new ChessboardPoint(x,y);
        } else {
            return null;
        }
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
