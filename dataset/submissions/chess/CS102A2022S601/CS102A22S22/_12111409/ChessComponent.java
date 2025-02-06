import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessGame game;

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

}
