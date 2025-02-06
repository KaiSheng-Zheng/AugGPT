import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> aa = new ArrayList<ChessboardPoint>();
        int x, y, a = -1, b = -1, c = 2, d = 2;
        x = getSource().getX();
        y = getSource().getY();
        if (x == 0) {
            a++;
        } else if (x == 7) {
            c--;
        }
        if (y == 0) {
            b++;
        } else if (y == 7) {
            d--;
        }
        for (int j = b; j < d; j++) {
            for (int i = a; i < c; i++) {
                if (chees[x+i][y+j] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + i, y + j));
                } else if (chees[x+i][y+j].getChessColor()!= getChessColor()) {
                    aa.add(new ChessboardPoint(x + i, y + j));
                }
            }
        }
        return aa;
    }
}
