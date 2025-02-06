import java.util.List;

public class KnightChessComponent  extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
