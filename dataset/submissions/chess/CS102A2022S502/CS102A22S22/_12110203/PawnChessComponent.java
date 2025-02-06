import java.util.List;

public class PawnChessComponent  extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
