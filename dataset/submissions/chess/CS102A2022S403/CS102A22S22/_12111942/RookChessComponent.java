import java.util.List;
public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public RookChessComponent(ChessColor chesscolor) {
        this.chessColor=chesscolor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
