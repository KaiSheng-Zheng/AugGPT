import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent(int x, int y, char name) {
        super(x, y, name);
    }

    public QueenChessComponent() {
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l = new ArrayList<>();
        int x = getX() - 1, y = getY() - 1;

        while (x >= 0 && y>=0 && ! chessboard[x][y].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(x, y));
                x--;
                y--;
            } else {
                l.add(new ChessboardPoint(x, y));
                break;
            }
        }

        int x2 = getX() + 1, y2 = getY() - 1;
        while (x2 <= 7 && y2>=0 && !chessboard[x2][y2].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x2][y2].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(x2, y2));
                x2++;
                y2--;
            } else {
                l.add(new ChessboardPoint(x2, y2));
                break;
            }
        }

        int x3 = getX() - 1, y3 = getY() + 1;
        while (y3 <= 7 && x3>=0 && !chessboard[x3][y3].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x3][y3].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(x3, y3));
                x3--;
                y3++;
            } else {
                l.add(new ChessboardPoint(x3, y3));
                break;
            }
        }

        int x4 = getX() + 1, y4 = getY() + 1;
        while (y4 <=7 && x4<=7 && !chessboard[x4][y4].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x4][y4].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(x4, y4));
                x4++;
                y4++;
            } else {
                l.add(new ChessboardPoint(x4, y4));
                break;
            }
        }

        int i = getX() - 1, j = getY();

        while (i >= 0 && !chessboard[i][j].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i][j].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(i, j));
                i--;
            } else {
                l.add(new ChessboardPoint(i, j));
                break;
            }
        }

        int i2 = getX() + 1, j2 = getY();
        while (i2 <= 7 && !chessboard[i2][j2].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i2][j2].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(i2, j2));
                i2++;
            } else {
                l.add(new ChessboardPoint(i2, j2));
                break;
            }
        }

        int i3 = getX(), j3 = getY() + 1;
        while (j3 <= 7 && !chessboard[i3][j3].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i3][j3].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(i3, j3));
                j3++;
            } else {
                l.add(new ChessboardPoint(i3, j3));
                break;
            }
        }

        int i4 = getX(), j4 = getY() - 1;
        while (j4 >= 0 && !chessboard[i4][j4].getChessColor().equals(this.getChessColor())) {
            if (chessboard[i4][j4].getChessColor().equals(ChessColor.NONE)) {
                l.add(new ChessboardPoint(i4, j4));
                j4--;
            } else {
                l.add(new ChessboardPoint(i4, j4));
                break;
            }
        }
        return l;
    }


}