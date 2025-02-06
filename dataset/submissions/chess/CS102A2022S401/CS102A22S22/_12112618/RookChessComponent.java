import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessComponents) {
        super(source, name,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        goCross();
        return canMovePoints;
    }
}
