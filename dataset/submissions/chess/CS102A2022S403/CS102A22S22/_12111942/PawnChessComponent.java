import java.util.List;
public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public PawnChessComponent(ChessColor chesscolor) {
        this.chessColor=chesscolor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
