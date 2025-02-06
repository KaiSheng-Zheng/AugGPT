import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'K' : 'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();
        ChessboardPoint source = getSource();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                ChessboardPoint pos = source.offset(i, j);
                if (canMoveToBasic(pos)) {
                    pattern.add(pos);
                }
            }
        }

        return pattern;
    }
}