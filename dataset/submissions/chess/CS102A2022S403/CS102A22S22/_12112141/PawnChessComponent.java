import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    private boolean inSrcPlace() {
        if (getChessColor().equals(ChessColor.BLACK)) {
            return getSource().getX() == 1;
        } else {
            return getSource().getX() == 6;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        boolean inPlace = inSrcPlace();
        ChessboardPoint src = getSource();
        System.out.println(src + " " + name);
        List<ChessboardPoint> list = new ArrayList<>();

        int sign = 1;
        if (getChessColor().equals(ChessColor.WHITE))
            sign = -1;
        ChessboardPoint dst = null;
        boolean flag = false;
        dst = src.offset(sign * 1, 0);
        if (dst != null && getChessComponent(dst).getChessColor().equals(ChessColor.NONE)) {
            list.add(dst);
            flag = true;
        }
        if (inPlace && flag) {
            dst = src.offset(sign * 2, 0);
            if (dst != null && getChessComponent(dst).getChessColor().equals(ChessColor.NONE)) {
                list.add(dst);
            }
        }

        // hit other
        dst = src.offset(sign * 1, 1);
        if (dst != null && isEnemy(dst))
            list.add(dst);

        dst = src.offset(sign * 1, -1);
        if (dst != null && isEnemy(dst))
            list.add(dst);

        return list;
    }
}
