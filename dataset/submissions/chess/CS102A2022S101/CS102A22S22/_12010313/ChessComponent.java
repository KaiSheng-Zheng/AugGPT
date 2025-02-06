import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;

    public void setBlackColor() {
        chessColor = ChessColor.BLACK;
    }

    public void setWhiteColor() {
        chessColor = ChessColor.WHITE;
    }

    public void setNoneColor() {
        chessColor = ChessColor.NONE;
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
