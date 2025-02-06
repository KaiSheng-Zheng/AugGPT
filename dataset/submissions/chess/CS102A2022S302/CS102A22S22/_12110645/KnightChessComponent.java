import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }
}
