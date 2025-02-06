import java.util.List;
public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public ChessboardPoint getChessboardPoint() {
        return source;
    }
    public void pass(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    //should design
    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        this.source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
    }
    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){
        this.source=chessboardPoint;
        this.chessColor=chessColor;
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

}
