import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.WHITE) {
            this.name = 'b';
        } else {
            this.name = 'B';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
