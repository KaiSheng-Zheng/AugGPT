import java.util.ArrayList;
import java.util.List;

/**
 * this class is a comonent for role-king
 *
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class KingChessComponent extends ChessComponent {

    // king can execute the offset
    private static int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> res = new ArrayList<>();
        for (int[] ints : dir) {
            ChessboardPoint offset = this.getSource().offset(ints[0], ints[1]);
            if (offset != null & !equalColor(chessComponents[offset.getX()][offset.getY()])) {
                   res.add(offset);
            }
        }
        return res;
    }
}
