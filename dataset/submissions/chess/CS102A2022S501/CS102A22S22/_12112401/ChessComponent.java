import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    //should design
    private ChessboardPoint source;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponent;

    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        String a = String.valueOf(name);
        return a;
    }

}