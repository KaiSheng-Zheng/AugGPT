import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'r';
        }
        return 'R';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSource().getX() == i && chessComponents[i][j].getChessColor() != getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                    boolean b = true;
                    for (int col = Math.min(getSource().getY(), j) + 1;
                         col < Math.max(getSource().getY(), j); col++) {
                        if (!(chessComponents[getSource().getX()][col] instanceof EmptySlotComponent)) {
                            b = false;
                            break;
                        }
                    }
                    if (b) {
                        a.add(new ChessboardPoint(i,j));
                    }
                } else if (getSource().getY() == j && chessComponents[i][j].getChessColor() != getChessColor()) {
                    boolean b = true;
                    for (int row = Math.min(getSource().getX(), i) + 1;
                         row < Math.max(getSource().getX(), i); row++) {
                        if (!(chessComponents[row][getSource().getY()] instanceof EmptySlotComponent)) {
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
        return a;
    }

}