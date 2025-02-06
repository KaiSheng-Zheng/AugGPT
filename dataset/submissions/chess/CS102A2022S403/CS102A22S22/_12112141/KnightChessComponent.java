import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> list = new ArrayList<>();

        int[][] dir = new int[][]{
                {1, 2},
                {-1, 2},
                {1, -2},
                {-1, -2},
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2, -1},
        };

        for (int[] d : dir) {
            ChessboardPoint dst = source.offset(d[0], d[1]);
            if (dst == null)
                continue;
            if (getChessComponent(dst).getChessColor().equals(getChessColor()))
                continue;

            list.add(dst);
        }
        return list;
    }
}
