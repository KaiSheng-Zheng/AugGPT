import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (getChessColor() == ChessColor.BLACK) {
            if (x == 1
                    && getChessComponents()[2][y].getChessColor() == ChessColor.NONE
                    && getChessComponents()[3][y].getChessColor() == ChessColor.NONE) {
                ans.add(new ChessboardPoint(3, y));
            }
            if (x + 1 <= 7 && getChessComponents()[x + 1][y].getChessColor() == ChessColor.NONE)
                ans.add(new ChessboardPoint(x + 1, y));
            if (x + 1 <= 7 && y + 1 <= 7 &&
                    getChessComponents()[x + 1][y + 1].getChessColor() != ChessColor.NONE
                    && getChessComponents()[x + 1][y + 1].getChessColor() != getChessColor())
                ans.add(new ChessboardPoint(x + 1, y + 1));
        } else {
            if (x == 6
                    && getChessComponents()[5][y].getChessColor() == ChessColor.NONE
                    && getChessComponents()[4][y].getChessColor() == ChessColor.NONE) {
                ans.add(new ChessboardPoint(4, y));
            }
            if (x - 1 >= 0 &&
                    getChessComponents()[x - 1][y].getChessColor() == ChessColor.NONE)
                ans.add(new ChessboardPoint(x - 1, y));
            if (x - 1 >= 0 && y - 1 >= 0 &&
                    getChessComponents()[x - 1][y - 1].getChessColor() != ChessColor.NONE
                    && getChessComponents()[x - 1][y - 1].getChessColor() != getChessColor())
                ans.add(new ChessboardPoint(x - 1, y - 1));
        }

        return ans;
    }
}
