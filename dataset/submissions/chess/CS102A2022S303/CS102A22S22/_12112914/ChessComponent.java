import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public static ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();



    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
