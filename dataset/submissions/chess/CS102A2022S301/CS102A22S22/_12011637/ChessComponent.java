import java.util.List;

public abstract class ChessComponent {
    //should design
    public ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent chessboard;

    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(ChessColor chessColor, ChessboardPoint chessComponents){}


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
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessboard(ChessComponent[][] chessComponents){
        this.chessboard = chessboard;
    }

    protected boolean equalColor(ChessComponent o){
        return this.getChessColor().equals(o.getChessColor());
    }
}
