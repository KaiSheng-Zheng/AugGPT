import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    ChessComponent[][] chessComponents;

    public RookChessComponent(ChessColor chessColor, ChessboardPoint source, ChessComponent[][] chessComponents) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            name = 'r';
        } else if (chessColor == ChessColor.BLACK) {
            name = 'R';
        }
        this.chessComponents=chessComponents;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        boolean p;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                p = true;
                ChessboardPoint b = new ChessboardPoint(i, j);
                if ((Math.abs(j - getSource().getY()) != 0) || (Math.abs(i - getSource().getX()) != 0)) {
                    if (!chessComponents[i][j].getChessColor().equals(getChessColor())) {
                        if ((Math.abs(j - getSource().getY()) == 0)) {
                            int col = getSource().getY();
                            for (int row = Math.min(getSource().getX(), i) + 1;
                                 row < Math.max(getSource().getX(), i); row++) {
                                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                    p = false;
                                    break;
                                }
                            }
                        }
                        else if (Math.abs(i - getSource().getX()) == 0) {
                            int row = getSource().getX();
                            for (int col = Math.min(getSource().getY(), j) + 1;
                                 col < Math.max(getSource().getY(), j); col++) {
                                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                    p = false;
                                    break;
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
                    if (p) {
                        a.add(b);
                    }
                }
            }
        }
        return a;
    }
}


