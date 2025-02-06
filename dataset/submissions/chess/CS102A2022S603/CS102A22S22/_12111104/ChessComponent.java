import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public ChessColor getChessColor() {
        return chessColor;
    }
    //should design
    public ChessComponent(){
//        this.source=source;
//        this.chessColor=chessColor;
//        this.name=name;
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
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
