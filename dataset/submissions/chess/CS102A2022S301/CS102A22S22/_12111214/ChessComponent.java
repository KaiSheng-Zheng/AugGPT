import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents = new ChessComponent[8][8];

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource(){
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
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
