import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    //user defined
    protected ChessComponent[][] chessboard;
    //should design
    public ChessComponent(){}
    public ChessComponent (ChessComponent[][] chessboard) {
        this.chessboard=chessboard;
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
    //set get

    public void setName(char name) {
        this.name = name;
    }
    public char getName() {
        return name;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
