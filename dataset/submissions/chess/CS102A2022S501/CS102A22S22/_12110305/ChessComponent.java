import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    ChessColor getComponentColor(char component){
        if (component == '_'){
            return ChessColor.NONE;}
        else if(component >= 'A' && component <= 'Z' ){
            return ChessColor.BLACK;}
        else return ChessColor.WHITE;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void getChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
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
