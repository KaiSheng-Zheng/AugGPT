import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    //should design
    public ChessComponent(){

    }

    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor,char name) {
        this.source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


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

}
