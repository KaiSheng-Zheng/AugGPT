import java.util.ArrayList;
import java.util.List;

/**
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class KnightChessComponent extends ChessComponent{

    private static int[][] dir = new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{2,-1},{2,1},{1,-2},{1,2}};

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name,
                                ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> res = new ArrayList<>();
        for (int[] ints : dir) {
            ChessboardPoint offset = this.getSource().offset(ints[0], ints[1]);
            if (offset != null) {
                ChessComponent t = chessComponents[offset.getX()][offset.getY()];
                if(!equalColor(t)) res.add(offset);
            }
        }
        return res;
    }
}
