import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    public int first = 0;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    private ChessColor chessColor;

    public ChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    protected char name;
    public ChessComponent[][] chessboard;

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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

    public boolean canMove(ChessComponent[][] chessComponents, ChessboardPoint destination){
        return false;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

}
