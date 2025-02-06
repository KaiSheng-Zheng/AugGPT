import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source=source;
        this.chessColor=chessColor;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor,ChessComponent[][] chessboard) {
        this.source=source;
        this.chessColor=chessColor;
        this.chessboard=chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
