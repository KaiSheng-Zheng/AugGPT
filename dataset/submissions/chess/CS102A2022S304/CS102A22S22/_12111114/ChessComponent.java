import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int x;
    private int y;

    //should design
    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    public char tochar() {
        return '_';
    }

    public int getType() {
        return 1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
