import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessComponents = new ChessComponent[8][8];

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public static ChessComponent getChessComponents(int x, int y) {
        return chessComponents[x][y];
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
