import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public PawnChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
        name = c;
        setChessColor(color);
        setSource(chessboardPoint);
    }
}
