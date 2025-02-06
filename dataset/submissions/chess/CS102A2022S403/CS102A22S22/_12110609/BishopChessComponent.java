import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public BishopChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
        name = c;
        setChessColor(color);
        setSource(chessboardPoint);
    }
}
