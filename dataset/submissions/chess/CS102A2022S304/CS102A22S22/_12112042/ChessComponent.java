import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    //should design
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    //should design
    public ChessComponent(){}

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
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

}
