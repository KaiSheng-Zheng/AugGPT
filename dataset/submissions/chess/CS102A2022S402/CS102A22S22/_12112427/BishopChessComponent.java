import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source,ChessComponent[][] chessComponents) {
        if (chessColor == ChessColor.WHITE) {
            name = 'b';
        } else if (chessColor == ChessColor.BLACK) {
            name = 'B';
        }
        setSource(source);
        setChessColor(chessColor);
        this.chessComponents=chessComponents;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        boolean p =true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint b = new ChessboardPoint(i, j);
                if ((Math.abs(j - getSource().getY()) != 0) && (Math.abs(i - getSource().getX()) != 0)) {
                    if (!chessComponents[i][j].getChessColor().equals(getChessColor())) {
                        if ((Math.abs(j - getSource().getY()) == Math.abs(i - getSource().getX()))) {
                            int col = getSource().getY();
                            int row = getSource().getX();
                            if (j > getSource().getY() && i > getSource().getX()) {
                                for (; col + 1 < j && row + 1 < i; col++, row++) {
                                    if (!(chessComponents[row + 1][col + 1] instanceof EmptySlotComponent)) {
                                        p = false;
                                        break;
                                    }
                                }
                            }
                            else if (j < getSource().getY() && i > getSource().getX()) {
                                for (; col - 1 > j && row + 1 < i; col--, row++) {
                                    if (!(chessComponents[row + 1][col - 1] instanceof EmptySlotComponent)) {
                                        p = false;
                                        break;
                                    }
                                }
                            }
                            else if (j > getSource().getY() && i < getSource().getX()) {
                                for (; col + 1 < j && row - 1 > i; col++, row--) {
                                    if (!(chessComponents[row - 1][col + 1] instanceof EmptySlotComponent)) {
                                        p = false;
                                        break;
                                    }
                                }
                            }
                            else if (j < getSource().getY() && i < getSource().getX()) {
                                for (; col - 1 > j && row - 1 > i; col--, row--) {
                                    if (!(chessComponents[row - 1][col - 1] instanceof EmptySlotComponent)) {
                                        p = false;
                                        break;
                                    }
                                }
                            }
                        }
                        else {
                            p = false;
                        }
                    }
                    else {
                        p = false;
                    }
                }
                else {
                    p = false;
                }
                if (p) {
                    a.add(b);
                }
                p = true;
            }
        }
        return a;
    }
}




