import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;

    protected ChessComponent[][] chessBoard;

    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
