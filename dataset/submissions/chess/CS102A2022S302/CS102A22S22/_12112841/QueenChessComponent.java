import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.WHITE) {
            this.name = 'q';
        } else {
            this.name = 'Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}