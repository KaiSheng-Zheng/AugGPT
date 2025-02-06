import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessComponents) {
        super(source, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        goKnight();
        return canMovePoints;
    }
}
