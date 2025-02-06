import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
//user defined
    protected ChessComponent[][] chessboard;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessComponent(){}

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }
}
