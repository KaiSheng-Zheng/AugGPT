
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    private boolean twoBlock;

    public ChessComponent() {
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public void setChessPoint(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getChessPoint() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setTwoBlock(){
    }
}
