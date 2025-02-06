import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
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
                    if (chees[x][y - j] instanceof EmptySlotComponent) {
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
        for (int j = 1; j < 8 - y; j++) {
            if (!(chees[x][y + j] instanceof EmptySlotComponent)) {
                if (chees[x][y + j].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x, y + j));
                }
                break;
            } else {
                if (chees[x][y + j] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x, y + j));
                }
            }
        }

        for (int j = 1; j <= y; j++) {
            if (!(chees[x][y - j] instanceof EmptySlotComponent)) {
                if (chees[x][y - j].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x, y - j));
                }
                break;
            } else {
                if (chees[x][y - j] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x, y - j));
                }
            }
        }

        for (int j = 1; j <= x; j++) {
            if (!(chees[x - j][y] instanceof EmptySlotComponent)) {
                if (chees[x - j][y].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x - j, y));
                }
                break;
            } else {
                if (chees[x - j][y] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x - j, y));
                }
            }
        }

        for (int j = 1; j < 8 - x; j++) {
            if (!(chees[x + j][y] instanceof EmptySlotComponent)) {
                if (chees[x + j][y].getChessColor() != getChessColor()) {
                    aa.add(new ChessboardPoint(x + j, y));
                }
                break;
            } else {
                if (chees[x + j][y] instanceof EmptySlotComponent) {
                    aa.add(new ChessboardPoint(x + j, y));
                }
            }
        }
        return aa;
    }

}
