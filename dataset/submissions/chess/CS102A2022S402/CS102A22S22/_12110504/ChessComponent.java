import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    private ChessColor chessColor;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    protected char name;
    protected ChessComponent[][] chessboard;

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    //should design
    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
