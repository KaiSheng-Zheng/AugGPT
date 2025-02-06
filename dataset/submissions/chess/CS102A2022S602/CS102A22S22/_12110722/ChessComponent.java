import java.util.List;

public abstract class ChessComponent {
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    private ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor){
            this.chessColor = chessColor;
            this.source=source;
    }
    public ChessComponent(ChessColor chessColor){
        this(null,chessColor);
    }
    public ChessComponent(){

    }


    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    ;

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }
}
