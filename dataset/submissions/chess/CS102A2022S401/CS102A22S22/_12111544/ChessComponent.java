import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name, ChessComponent[][] chessComponents){
        source=chessboardPoint;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents = chessComponents;
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

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    

    public ChessboardPoint getSource(){
        return source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
