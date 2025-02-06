import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

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
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setSource(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    public void setChessComponents(ChessComponent[][] chessComponents){}
}
