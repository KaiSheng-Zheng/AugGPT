import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToPoints1 = new ArrayList<>();
        int x1 = getSource().getX();
        int y1 = getSource().getY();
        int i;


        for (i = 1; i + y1 < 8; i++) {
            if (belonging.getChessComponents()[x1][i + y1] instanceof EmptySlotComponent)
                canMoveToPoints1.add(new ChessboardPoint(x1, i + y1));
            else {
                if (belonging.getChessComponents()[x1][i + y1].getChessColor() == belonging.getChessComponents()[x1][y1].getChessColor()) break;
                else canMoveToPoints1.add(new ChessboardPoint(x1, i + y1));break;
            }
        }

        for (i = -1; i + y1 >= 0; i--) {
            if (belonging.getChessComponents()[x1][i + y1] instanceof EmptySlotComponent)
                canMoveToPoints1.add(new ChessboardPoint(x1, i + y1));
            else {
                if (belonging.getChessComponents()[x1][i + y1].getChessColor() == belonging.getChessComponents()[x1][y1].getChessColor()) break;
                else canMoveToPoints1.add(new ChessboardPoint(x1, i + y1));break;
            }
        }

        for (i = 1; i + x1 < 8; i++) {
            if (belonging.getChessComponents()[x1 + i][y1] instanceof EmptySlotComponent)
                canMoveToPoints1.add(new ChessboardPoint(x1 + i, y1));
            else {
                if (belonging.getChessComponents()[x1 + i][y1].getChessColor() == belonging.getChessComponents()[x1][y1].getChessColor()) break;
                else canMoveToPoints1.add(new ChessboardPoint(x1 + i, y1));break;
            }
        }
        for (i = -1; i + x1 >= 0; i--) {
            if (belonging.getChessComponents()[x1 + i][y1] instanceof EmptySlotComponent)
                canMoveToPoints1.add(new ChessboardPoint(x1 + i, y1));
            else {
                if (belonging.getChessComponents()[x1 + i][y1].getChessColor() == belonging.getChessComponents()[x1][y1].getChessColor()) break;
                else canMoveToPoints1.add(new ChessboardPoint(x1 + i, y1));break;
            }
        }
       return canMoveToPoints1;
    }
}
