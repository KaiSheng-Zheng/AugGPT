import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        chessColor = color;
        source = chessboardPoint;
        if (chessColor.equals(ChessColor.WHITE))
            name = 'q';
        else
            name = 'Q';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i + source.getX() < 8 && i + source.getY() < 8; i++) {

        }
        return null;
    }
}