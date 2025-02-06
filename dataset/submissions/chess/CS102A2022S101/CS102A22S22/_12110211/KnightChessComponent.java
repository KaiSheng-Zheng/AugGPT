import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'N' : 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();
        ChessboardPoint source = getSource();

        pattern.add(source.offset(2, -1));
        pattern.add(source.offset(2, 1));
        pattern.add(source.offset(1, -2));
        pattern.add(source.offset(1, 2));
        pattern.add(source.offset(-2, -1));
        pattern.add(source.offset(-2, 1));
        pattern.add(source.offset(-1, -2));
        pattern.add(source.offset(-1, 2));

        return pattern.stream().filter(this::canMoveToBasic).collect(Collectors.toList());
    }
}