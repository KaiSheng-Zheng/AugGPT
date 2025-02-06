import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.WHITE) {
            this.name = 'p';
        } else {
            this.name = 'P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}