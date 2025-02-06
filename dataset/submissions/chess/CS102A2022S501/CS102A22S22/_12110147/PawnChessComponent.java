import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'p';
        }
        return 'P';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getChessColor() == ChessColor.BLACK && chessComponents[i][j].getChessColor() != ChessColor.BLACK && !(i == getSource().getX() && j == getSource().getY())) {
                    if (j == getSource().getY()) {
                        if (getSource().getX() == 1) {
                            if ((i - getSource().getX() == 1 && (chessComponents[i][j] instanceof EmptySlotComponent)) || (i - getSource().getX() == 2 && chessComponents[i][j] instanceof EmptySlotComponent && chessComponents[i - 1][j] instanceof EmptySlotComponent)) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        } else {
                            if (i - getSource().getX() == 1 && (chessComponents[i][j] instanceof EmptySlotComponent)) {
                                a.add(new ChessboardPoint(i,j));
                            }

                        }
                    }
                    if (getSource().getY() - j == getSource().getX() - i || getSource().getY() - j == i - getSource().getX()) {
                        if (i - getSource().getX() == 1 && !(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            a.add(new ChessboardPoint(i,j));
                        }
                    }
                }
                if (getChessColor() == ChessColor.WHITE && chessComponents[i][j].getChessColor() != ChessColor.WHITE) {
                    if (j == getSource().getY()) {
                        if (getSource().getX() == 6) {
                            if ((i - getSource().getX() == -1 && (chessComponents[i][j] instanceof EmptySlotComponent)) || (i - getSource().getX() == -2 && (chessComponents[i][j] instanceof EmptySlotComponent) && (chessComponents[i + 1][j] instanceof EmptySlotComponent))) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        } else {
                            if (i - getSource().getX() == -1 && (chessComponents[i][j] instanceof EmptySlotComponent)) {
                                a.add(new ChessboardPoint(i,j));
                            }
                        }
                    }
                    if (getSource().getY() - j == getSource().getX() - i || getSource().getY() - j == i - getSource().getX()) {
                        if (i - getSource().getX() == -1 && !(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            a.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }
        return a;
    }
}