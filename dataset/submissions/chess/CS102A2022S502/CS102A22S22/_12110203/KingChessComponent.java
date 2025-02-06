import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
