import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(int x, int y, char name) {
        super(x, y, name);
    }

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l1 = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if ((Math.abs(i - getX()) == 1 && Math.abs(j - getY()) == 2) && !(chessboard[i][j].getChessColor().equals(this.getChessColor()))) {
//                    l1.add(new ChessboardPoint(i, j));
//                }
//                if ((Math.abs(i - getX()) == 2 && Math.abs(j - getY()) == 1) && !(chessboard[i][j].getChessColor().equals(this.getChessColor()))) {
//                    l1.add(new ChessboardPoint(i, j));
//                }
//            }
//        }
        int i = getX() - 1, j = getY();

        while (i >= 0 && !chessboard[i][j].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i][j].getChessColor().equals(ChessColor.NONE)) {
                l1.add(new ChessboardPoint(i, j));
                i--;
            } else {
                l1.add(new ChessboardPoint(i, j));
                break;
            }
        }

        int i2 = getX() + 1, j2 = getY();
        while (i2 <= 7 && !chessboard[i2][j2].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i2][j2].getChessColor().equals(ChessColor.NONE)) {
                l1.add(new ChessboardPoint(i2, j2));
                i2++;
            } else {
                l1.add(new ChessboardPoint(i2, j2));
                break;
            }
        }

        int i3 = getX(), j3 = getY() + 1;
        while (j3 <= 7 && !chessboard[i3][j3].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i3][j3].getChessColor().equals(ChessColor.NONE)) {
                l1.add(new ChessboardPoint(i3, j3));
                j3++;
            } else {
                l1.add(new ChessboardPoint(i3, j3));
                break;
            }
        }

        int i4 = getX(), j4 = getY() - 1;
        while (j4 >= 0 && !chessboard[i4][j4].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i4][j4].getChessColor().equals(ChessColor.NONE)) {
                l1.add(new ChessboardPoint(i4, j4));
                j4--;
            } else {
                l1.add(new ChessboardPoint(i4, j4));
                break;
            }
        }

        return l1;
    }
}