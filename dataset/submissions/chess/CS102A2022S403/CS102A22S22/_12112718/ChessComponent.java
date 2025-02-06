import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected ChessboardPoint source0;
    protected ChessColor chessColor0;
    protected char name;
    ChessComponent[][] chessBoard;//be used to judge canMoveTo()

    //should design
    public ChessComponent() {}

    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        source0 = chessboardPoint;
        chessColor0 = color;
    }

    public void setChessboardPoint(ChessboardPoint source) {
        this.source0 = source;
    }

    protected void setChessBoard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }

    public ChessColor getChessColor() {
        return chessColor0;
    }

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