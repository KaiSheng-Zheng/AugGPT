import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> outcome = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean hasBarrier = false;
                if (Math.abs(getSource().getX() - i) == Math.abs(getSource().getY() - j) && i != getSource().getX() && chessComponents[i][j].getChessColor() != this.getChessColor()) {
                    if ((getSource().getX() < i && getSource().getY() < j) || (getSource().getX() > i && getSource().getY() > j)) {
                        for (int ith = Math.min(getSource().getX(), i) + 1, jth = Math.min(getSource().getY(), j) + 1; ith < Math.max(getSource().getX(), i); ith++, jth++) {
                            if (!(chessComponents[ith][jth] instanceof EmptySlotComponent)) {
                                hasBarrier = true;

                            }
                        }
                        if (hasBarrier == false) {
                            outcome.add(new ChessboardPoint(i, j));

                        }

                    } else if ((getSource().getX() < i && getSource().getY() > j) || (getSource().getX() > i && getSource().getY() < j)) {
                        for (int ith = Math.min(getSource().getX(), i) + 1, jth = Math.max(getSource().getY(), j) - 1; ith < Math.max(getSource().getX(), i); ith++, jth--) {
                            if (!(chessComponents[ith][jth] instanceof EmptySlotComponent)) {
                                hasBarrier = true;

                            }
                        }
                        if (hasBarrier == false) {
                            outcome.add(new ChessboardPoint(i, j));

                        }
                    }
                }
            }
        }
        return outcome;
    }
}
