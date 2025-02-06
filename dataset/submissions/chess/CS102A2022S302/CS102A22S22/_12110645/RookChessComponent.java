import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }
}
