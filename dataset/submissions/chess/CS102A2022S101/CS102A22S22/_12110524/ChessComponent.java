import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public abstract List<ChessboardPoint> canMoveTo();
    protected static ChessComponent[][] board;

    public ChessComponent() {}

    public static void setBoard(ChessComponent[][] board) {
        ChessComponent.board = board;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setSource(ChessboardPoint source)  {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return this.source;
    }
}