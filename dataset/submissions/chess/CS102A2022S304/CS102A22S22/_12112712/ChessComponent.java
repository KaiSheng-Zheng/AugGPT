import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        this.chessColor = chessColor;
        this.source =chessboardPoint;
    }
    public ChessComponent(ChessColor chessColor){
        this.chessColor = chessColor;
    }
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

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void setSource(ChessboardPoint chessboardPoint){
        source = chessboardPoint;
    }
}
