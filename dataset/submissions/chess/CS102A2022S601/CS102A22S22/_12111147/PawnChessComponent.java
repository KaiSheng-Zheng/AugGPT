import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(int x, int y, char name) {
        super(x, y, name);
    }

    public PawnChessComponent() {
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l1 = new ArrayList<>();
        boolean isBlack = this.getChessColor().equals(ChessColor.BLACK);
        if (isBlack) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i - getX() == 1 && j == getY()) && (chessboard[i][j].getChessColor().equals(ChessColor.NONE))) {
                        l1.add(new ChessboardPoint(i, j));
                        if (getX() == 1 && (chessboard[2][j].getChessColor().equals(ChessColor.NONE))) {
                            l1.add(new ChessboardPoint(2, j));
                        }
                    }
                    if (Math.abs(j - getY()) == 1 && i - getX() == 1 && (chessboard[i][j].getChessColor().equals(ChessColor.WHITE))) {
                        l1.add(new ChessboardPoint(i, j));
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((getX() - 1 == 1 && j == getY()) && (chessboard[i][j].getChessColor().equals(ChessColor.NONE))) {
                        l1.add(new ChessboardPoint(i, j));
                        if (getX() == 6 && (chessboard[5][j].getChessColor().equals(ChessColor.NONE))) {
                            l1.add(new ChessboardPoint(5, j));
                        }
                    }
                    if (Math.abs(getY() - j) == 1 && getX() - i == 1 && (chessboard[i][j].getChessColor().equals(ChessColor.BLACK))) {
                        l1.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return l1;
    }
}