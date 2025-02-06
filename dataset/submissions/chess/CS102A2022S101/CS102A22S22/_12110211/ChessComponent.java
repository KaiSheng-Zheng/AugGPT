import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;

    protected final ChessComponent[][] board;

    public ChessComponent(ChessComponent[][] board) {
        this.board = board;
    }

    public ChessComponent() {
        this(null);
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    protected ChessboardPoint getSource() {
        return source;
    }

    protected void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    protected void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    protected boolean canMoveToBasic(ChessboardPoint source) {
        if (source == null || this.source.equals(source) || source.getX() < 0 || source.getX() > 7 || source.getY() < 0 || source.getY() > 7) {
            return false;
        }

        ChessComponent target = board[source.getX()][source.getY()];
        return target == null || target instanceof EmptySlotComponent || target.getChessColor() != chessColor;
    }
}