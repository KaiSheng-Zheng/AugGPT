import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];

    //should design
    public ChessComponent(){}



    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    ;

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf( this.name );
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

    public void loadChessboard(ChessComponent[][] chessComponents){
        chessboard = chessComponents;
    }


    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }


}
