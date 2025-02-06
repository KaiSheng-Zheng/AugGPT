import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> aa = new ArrayList<ChessboardPoint>();
        int x, y;
        x = getSource().getX();
        y = getSource().getY();
        if (getChessColor() == ChessColor.BLACK) {
            if (x == 7) {

            } else {
                for (int i = -1; i < 2; i++) {
                    if (y + i >= 0 && y + i <= 7) {
                        if (i != 0) {
                            if (!(chees[x +1][y + i] instanceof EmptySlotComponent)) {
                                if (chees[x + 1][y + i].getChessColor() != getChessColor()) {
                                    aa.add(new ChessboardPoint(x + 1, y + i));
                                }
                            }
                        }
                    }
                }
                if (chees[x+1][y  ] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x+1, y ));
                }
                if (x == 1) {
                    if (chees[3][y] instanceof EmptySlotComponent) {
                        aa.add(new ChessboardPoint(3, y));
                    }
                }
            }

        } else if (x != 0) {
            for (int i = -1; i < 2; i++) {
                if (y + i >= 0 && y + i <= 7) {
                    if (i != 0) {
                        if (!(chees[x -1][y + i] instanceof EmptySlotComponent)) {
                            if (chees[x -1][y +i].getChessColor() != getChessColor()) {
                                aa.add(new ChessboardPoint(x -1, y +i));
                            }
                        }
                    }
                }
            }
            if (chees[x-1][y ] instanceof EmptySlotComponent) {
                aa.add(new ChessboardPoint(x-1, y ));
            }
            if (x == 6) {
                if (chees[4][y] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(4, y));
                }
            }
        }
        return aa;
    }
}

