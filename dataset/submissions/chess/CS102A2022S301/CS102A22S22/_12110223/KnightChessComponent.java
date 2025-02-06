import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> aa = new ArrayList<ChessboardPoint>();
        int x, y;
        x = getSource().getX();
        y = getSource().getY();
        if (x +1<=7 && y -2 >=0) {
            if (!(chees[x + 1][y - 2] instanceof EmptySlotComponent)) {
                if (chees[x + 1][y - 2].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x + 1, y - 2));
                }
            } else {
                if (chees[x + 1][y - 2] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + 1, y - 2));
                }
            }
        }
        if (x +1<=7 && y +2 <=7) {
            if (!(chees[x + 1][y +2] instanceof EmptySlotComponent)) {
                if (chees[x + 1][y +2].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x + 1, +2));
                }
            } else {
                if (chees[x + 1][y +2] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + 1, y +2));
                }
            }
        }
        if (x +2<=7 && y +1 <=7) {
            if (!(chees[x + 2][y +1] instanceof EmptySlotComponent)) {
                if (chees[x + 2][y +1].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x + 2, +1));
                }
            } else {
                if (chees[x + 2][y +1] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + 2, y +1));
                }
            }
        }
        if (x +2<=7 && y -1 >=0) {
            if (!(chees[x + 2][y -1] instanceof EmptySlotComponent)) {
                if (chees[x + 2][y -1].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x + 2, y-1));
                }
            } else {
                if (chees[x + 2][y -1] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + 2, y -1));
                }
            }
        }
        if (x -2>=0 && y -1 >=0) {
            if (!(chees[x - 2][y -1] instanceof EmptySlotComponent)) {
                if (chees[x - 2][y -1].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x - 2, y-1));
                }
            } else {
                if (chees[x - 2][y -1] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x - 2, y -1));
                }
            }
        }
        if (x -1>=0 && y -2 >=0) {
            if (!(chees[x - 1][y -2] instanceof EmptySlotComponent)) {
                if (chees[x - 1][y -2].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x - 1, y-2));
                }
            } else {
                if (chees[x - 1][y -2] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x - 1, y -2));
                }
            }
        }
        if (x -2>=0 && y +1 <=7) {
            if (!(chees[x - 2][y +1] instanceof EmptySlotComponent)) {
                if (chees[x - 2][y +1].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x - 2, y+1));
                }
            } else {
                if (chees[x - 2][y +1] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x - 2, y +1));
                }
            }
        }
        if (x -1>=0 && y +2 <=7) {
            if (!(chees[x - 1][y +2] instanceof EmptySlotComponent)) {
                if (chees[x - 1][y +2].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x - 1, y+2));
                }
            } else {
                if (chees[x - 1][y +2] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x - 1, y +2));
                }
            }
        }
            return aa;

    }
}
