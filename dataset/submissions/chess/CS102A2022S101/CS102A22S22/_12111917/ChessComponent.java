import java.util.List;

public abstract class ChessComponent {
    // should design
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    // should design
    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }


    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessboardPoint getChessboardPoint() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

}
