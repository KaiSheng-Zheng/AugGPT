import java.util.ArrayList;
import java.util.List;

/**
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class PawnChessComponent extends ChessComponent{

    private boolean is_firstStep;
    private static int[][] dir = new int[][]{{1,0}};

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
        this.is_firstStep = true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> res = new ArrayList<>();

        /**
         * white move
         */
        if(this.getChessColor().equals(ChessColor.BLACK)){
            ChessboardPoint offset = this.getSource().offset(dir[0][0], dir[0][1]);
            if (offset != null) {
                ChessComponent t = chessComponents[offset.getX()][offset.getY()];
                if(t.getChessColor().equals(ChessColor.NONE)) res.add(offset);
            }

            if(is_firstStep ) {
                offset = this.getSource().offset(dir[0][0] * 2, dir[0][1] * 2);
                if(offset != null) res.add(offset);
            }
        }
        else if(this.getChessColor().equals(ChessColor.WHITE)){
            ChessboardPoint offset = this.getSource().offset(-1 * dir[0][0], -1 * dir[0][1]);
            if (offset != null) {
                ChessComponent t = chessComponents[offset.getX()][offset.getY()];
                if(t.getChessColor().equals(ChessColor.NONE)) res.add(offset);
            }
            if(is_firstStep ) {
                offset = this.getSource().offset(dir[0][0] * -2, dir[0][1] * -2);
                if(offset != null) res.add(offset);
            }
        }
        return res;
    }


    public boolean isIs_firstStep() {
        return is_firstStep;
    }

    public void setIs_firstStep(boolean is_firstStep) {
        if(!this.is_firstStep) return;
        this.is_firstStep = is_firstStep;
    }
}
