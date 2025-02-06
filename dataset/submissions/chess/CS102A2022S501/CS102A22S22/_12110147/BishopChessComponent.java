import java.util.*;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'b';
        }
        return 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i ++) {
            for (int j = 0; j < 8; j++) {
                if (!(i == getSource().getX() && j == getSource().getY()) && chessComponents[i][j].getChessColor() != getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                    if (i - getSource().getX() == j - getSource().getY()) {
                        if (i - getSource().getX() > 0) {
                            boolean b = true;
                            for (int k = 1; k < i - getSource().getX() ; k++) {
                                if (!(chessComponents[getSource().getX() + k][getSource().getY() + k] instanceof EmptySlotComponent)) {
                                    b = false;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i, j));
                            }
                        } else {
                            boolean b = true;
                            for (int k = 1; k < getSource().getX() - i ; k++) {
                                if (!(chessComponents[i + k][j + k] instanceof EmptySlotComponent)) {
                                    b = false;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i, j));
                            }
                        }
                    }
                    if (i - getSource().getX() == getSource().getY() - j) {
                        if (i - getSource().getX() > 0) {
                            boolean b = true;
                            for (int k = 1; k < i - getSource().getX() ; k++) {
                                if (!(chessComponents[getSource().getX() + k][getSource().getY() - k] instanceof EmptySlotComponent)) {
                                    b = false;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i, j));
                            }
                        } else {
                            boolean b = true;
                            for (int  k= 1; k < getSource().getX() - i ; k++) {
                                if (!(chessComponents[i + k][j - k] instanceof EmptySlotComponent)) {
                                    b = false;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i, j));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}
