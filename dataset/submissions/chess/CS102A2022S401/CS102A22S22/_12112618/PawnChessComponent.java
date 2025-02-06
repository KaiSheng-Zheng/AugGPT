import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessComponents) {
        super(source, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        goPawn();
        return canMovePoints;
    }
}
