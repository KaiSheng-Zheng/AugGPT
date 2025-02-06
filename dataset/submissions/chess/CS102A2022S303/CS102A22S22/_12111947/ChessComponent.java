import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    protected ChessComponent [][] chessboard;

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }



    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);    }

}
