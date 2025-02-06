import java.util.ArrayList;
import java.util.List;

/**
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class RookChessComponent extends ChessComponent{

    private static int[][] dir = new int[][]{{-1,0},{0,1},{0,-1},{1,0}};

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name,
                              ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<>();

        for (int[] ints : dir) {
            for(int d = 1; ; ++d){
                ChessboardPoint offset = this.getSource().offset(ints[0] * d, ints[1] * d);
                if (offset != null) {
                    ChessComponent t = chessComponents[offset.getX()][offset.getY()];
                    if(!equalColor(t)){
                        res.add(offset);
                        if(!t.getChessColor().equals(ChessColor.NONE)) break;
                    }
                    else break;
                }
                else break;
            }
        }
        return res;
    }
}
