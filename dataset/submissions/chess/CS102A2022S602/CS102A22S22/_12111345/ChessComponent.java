import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];
    //should design


    public ChessComponent(){}
    public ChessComponent(ChessColor chessColor,char name){
        this.chessColor = chessColor;
        this.name = name;

    }
    public ChessComponent (ChessboardPoint source,ChessColor chessColor,char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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
}
