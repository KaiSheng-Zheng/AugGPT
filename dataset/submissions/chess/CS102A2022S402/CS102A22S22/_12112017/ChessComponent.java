import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    //should design

    public ChessComponent() {

    }

    public ChessComponent(ChessboardPoint chessboardPoint, ChessColor color, char name){
        source = chessboardPoint;
        chessColor = color;
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

}
