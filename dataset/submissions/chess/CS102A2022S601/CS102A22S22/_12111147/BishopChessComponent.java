import java.util.ArrayList;

import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(int x, int y, char name) {
        super(x, y, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l2 = new ArrayList<>();

        int x = getX() - 1, y = getY() - 1;
        while (x >= 0 && y>=0 && ! chessboard[x][y].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x][y].getChessColor().equals(ChessColor.NONE)) {
                l2.add(new ChessboardPoint(x, y));
                x--;
                y--;
            } else {
                l2.add(new ChessboardPoint(x, y));
                break;
            }
        }

        int x2 = getX() + 1, y2 = getY() - 1;
        while (x2 <= 7 && y2>=0 && !chessboard[x2][y2].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x2][y2].getChessColor().equals(ChessColor.NONE)) {
                l2.add(new ChessboardPoint(x2, y2));
                x2++;
                y2--;
            } else {
                l2.add(new ChessboardPoint(x2, y2));
                break;
            }
        }

        int x3 = getX() - 1, y3 = getY() + 1;
        while (x3>=0 && y3<=7 && !chessboard[x3][y3].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x3][y3].getChessColor().equals(ChessColor.NONE)) {
                l2.add(new ChessboardPoint(x3, y3));
                x3--;
                y3++;
            } else {
                l2.add(new ChessboardPoint(x3, y3));
                break;
            }
        }

        int x4 = getX() + 1, y4 = getY() + 1;
        while (y4 <=7 && x4<=7 && !chessboard[x4][y4].getChessColor().equals(this.getChessColor())) {
            if (chessboard[x4][y4].getChessColor().equals(ChessColor.NONE)) {
                l2.add(new ChessboardPoint(x4, y4));
                x4++;
                y4++;
            } else {
                l2.add(new ChessboardPoint(x4, y4));
                break;
            }
        }

        return l2;
    }
}