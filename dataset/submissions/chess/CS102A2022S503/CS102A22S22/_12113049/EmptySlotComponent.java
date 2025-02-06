import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private final ChessColor chessColor;// What's the color
//    protected char name = '_';// What's the name


    public EmptySlotComponent(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
        this.chessColor = ChessColor.NONE;
        this.name = '_';
    }

    public ChessboardPoint getChessboardPoint() {return source;}

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {this.source = chessboardPoint;}

    public ChessColor getChessColor() {return chessColor;}

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
