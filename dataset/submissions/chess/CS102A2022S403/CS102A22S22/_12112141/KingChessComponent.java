import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        int[][] dir = new int[][]{
                {1, 1},
                {-1, 1},
                {1, -1},
                {-1, -1},
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1},
        };

        List<ChessboardPoint> list = new ArrayList<>();
        for (int[] d : dir) {
            ChessboardPoint dst = source.offset(d[0], d[1]);
            if (dst == null)
                continue;
            if(getChessColor().equals(getChessComponent(dst).getChessColor()))
                continue;
            list.add(dst);
        }
        return list;
    }
}

