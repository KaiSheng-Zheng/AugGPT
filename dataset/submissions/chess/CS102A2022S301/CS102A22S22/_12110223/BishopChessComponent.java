import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> aa = new ArrayList<ChessboardPoint>();
        int x, y;
        x = getSource().getX();
        y = getSource().getY();
        for (int j = 1; j < 8 ; j++) {
            if (x + j <= 7 && y + j <= 7) {
                if (!(chees[x + j][y + j] instanceof EmptySlotComponent)) {
                    if (chees[x + j][y + j].getChessColor() != getChessColor()) {
                        aa.add(new ChessboardPoint(x+j, y + j));
                    }
                    break;
                } else {
                    if (chees[x+j][y + j] instanceof EmptySlotComponent) {
                        aa.add(new ChessboardPoint(x+j, y + j));
                    }
                }
            }
        }

        for (int j = 1; j <8; j++) {
            if (x - j >= 0 && y - j >= 0) {
                if (!(chees[x-j][y - j] instanceof EmptySlotComponent)) {
                    if (chees[x-j][y - j].getChessColor() != getChessColor()) {
                        aa.add(new ChessboardPoint(x-j, y - j));
                    }
                    break;
                } else {
                    if (chees[x-j][y - j] instanceof EmptySlotComponent) {
                        aa.add(new ChessboardPoint(x-j, y - j));
                    }
                }
            }
        }

        for (int j = 1; j <8; j++) {
            if (x +j <= 7 && y - j >= 0) {
                if (!(chees[x + j][y - j] instanceof EmptySlotComponent)) {
                    if (chees[x + j][y - j].getChessColor() != getChessColor()) {
                        aa.add(new ChessboardPoint(x+j, y - j));
                    }
                    break;
                } else {
                    if (chees[x+j][y - j] instanceof EmptySlotComponent) {
                        aa.add(new ChessboardPoint(x+j, y - j));
                    }
                }
            }
        }

        for (int j = 1; j <8; j++) {
            if (x - j >= 0 && y + j <= 7) {
                if (!(chees[x-j][y + j] instanceof EmptySlotComponent)) {
                    if (chees[x-j][y + j].getChessColor() != getChessColor()) {
                        aa.add(new ChessboardPoint(x-j, y + j));
                    }
                    break;
                } else {
                    if (chees[x-j][y + j] instanceof EmptySlotComponent) {
                        aa.add(new ChessboardPoint(x-j, y + j));
                    }
                }
            }
        }
        return aa;
    }
}
