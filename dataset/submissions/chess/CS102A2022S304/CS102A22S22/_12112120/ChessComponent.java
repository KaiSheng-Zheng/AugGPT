
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name; // did not use the field "name" at all.

    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setSource(ChessboardPoint point){
        this.source=point;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessboardPoint point,ChessColor color){
        setChessColor(color);
        setSource(point);
    }
    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return null;
    }

}
