import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'q';
        }
        return 'Q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int row = getSource().getX();
                int col = getSource().getY();
                if (chessComponents[i][j].getChessColor() != getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                    if (getSource().getX() == i) {
                        boolean b = true;
                        for (col = Math.min(getSource().getY(), j) + 1; col < Math.max(getSource().getY(), j); col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                b = false;
                            }
                        }
                        if (b) {
                            a.add(new ChessboardPoint(i,j));
                        }
                    }
                    if (getSource().getY() == j) {
                        boolean b = true;
                        for (row = Math.min(getSource().getX(), i) + 1; row < Math.max(getSource().getX(), i); row++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                b = false;
                            }
                        }
                        if (b) {
                            a.add(new ChessboardPoint(i,j));
                        }
                    }
                    if (i - getSource().getX() == j - getSource().getY()) {
                        if (i - getSource().getX() > 0) {
                            boolean b = true;
                            for (int k = 1; k < i - getSource().getX() ; k++) {
                                if (!(chessComponents[getSource().getX() + k][getSource().getY() + k] instanceof EmptySlotComponent)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        } else {
                            boolean b = true;
                            for (int k = 1; k < getSource().getX() - i ; k++) {
                                if (!(chessComponents[i + k][j + k] instanceof EmptySlotComponent)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        }
                    }
                    if (i - getSource().getX() == getSource().getY() - j) {
                        if (i - getSource().getX() > 0) {
                            boolean b = true;
                            for (int k = 1; k < i - getSource().getX() ; k++) {
                                if (!(chessComponents[getSource().getX() + k][getSource().getY() - k] instanceof EmptySlotComponent)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        } else {
                            boolean b = true;
                            for (int k = 1; k < getSource().getX() - i ; k++) {
                                if (!(chessComponents[i + k][j - k] instanceof EmptySlotComponent)) {
                                    b = false;
                                    break;
                                }
                            }
                            if (b) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}