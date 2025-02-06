import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public QueenChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor color) {
        name = c;
        setChessColor(color);
        setSource(chessboardPoint);
    }
}
