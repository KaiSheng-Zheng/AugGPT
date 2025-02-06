import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessComponent;
    protected static ChessColor colorOfPlayer;

    public ChessComponent() {}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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


    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(int targetX, int targetY) {
    }
}
