import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessboard;

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }
    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setPoint(ChessboardPoint point) {
        this.source = point;
    }

}
