import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessComponents) {
        super(source, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        goSlash();
        return canMovePoints;
    }
}
