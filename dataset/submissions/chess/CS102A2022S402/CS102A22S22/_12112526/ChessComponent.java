import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    public ChessComponent(ChessColor chessColor) {
        this.chessColor=chessColor;
    }
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessComponent(ChessboardPoint source) {
        this.source = source;
    }
    public ChessComponent(){};

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

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

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public String toString() {
        return null;
    }
}
