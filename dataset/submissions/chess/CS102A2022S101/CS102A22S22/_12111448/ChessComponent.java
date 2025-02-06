import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    static ChessComponent chessComponents[][];

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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

    public void setChessColor(ChessColor chessColor){
        this.chessColor=chessColor;
    }

    public void setSource(ChessboardPoint p) {
        this.source=p;
    }


    public ChessboardPoint getSource() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }
}
