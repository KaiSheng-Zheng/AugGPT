import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessboardPoint destination;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public static void setChessComponents(ChessComponent[][] clone) {
    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}