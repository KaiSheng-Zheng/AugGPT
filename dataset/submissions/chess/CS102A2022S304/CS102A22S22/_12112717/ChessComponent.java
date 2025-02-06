import java.util.List;

public abstract class ChessComponent {


    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
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

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    //should design
    public ChessComponent() {
    }

    public ChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();



    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}
