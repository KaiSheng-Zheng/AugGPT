import java.util.ArrayList;
import java.util.List;

public class  PawnChessComponent extends ChessComponent {

     private ChessComponent[][] chessComponents;

     public PawnChessComponent(ChessColor chessColor, ChessboardPoint source,ChessComponent[][] chessComponents) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        }
        if (chessColor == ChessColor.BLACK) {
            name = 'P';
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
                if (!chessComponents[i][j].getChessColor().equals(getChessColor())) {
                    if (i - getSource().getX() == 1 && Math.abs(j - getSource().getY()) == 0 && getChessColor() == ChessColor.BLACK) {
                        if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            p = false;
                        }
                    } else if (i - getSource().getX() == 2 && Math.abs(j - getSource().getY()) == 0 && getChessColor() == ChessColor.BLACK && getSource().getX() == 1) {
                        if ((!(chessComponents[i][j] instanceof EmptySlotComponent)) || (!(chessComponents[i - 1][j] instanceof EmptySlotComponent))) {
                            p = false;
                        }
                    } else if (i - getSource().getX() == 1 && Math.abs(j - getSource().getY()) == 1 && getChessColor() == ChessColor.BLACK) {
                        if (((chessComponents[i][j]).getChessColor() != ChessColor.WHITE)) {
                            p = false;
                        }
                    } else if (getSource().getX() - i == 1 && Math.abs(j - getSource().getY()) == 0 && getChessColor() == ChessColor.WHITE) {
                        if (!(chessComponents[i][j] instanceof EmptySlotComponent)) {
                            p = false;
                        }
                    } else if (getSource().getX() - i == 2 && Math.abs(j - getSource().getY()) == 0 && getChessColor() == ChessColor.WHITE && getSource().getX() == 6) {
                        if ((!(chessComponents[i][j] instanceof EmptySlotComponent)) || (!(chessComponents[i + 1][j] instanceof EmptySlotComponent))) {
                            p = false;
                        }
                    } else if (i - getSource().getX() == -1 && Math.abs(j - getSource().getY()) == 1 && getChessColor() == ChessColor.WHITE) {
                        if (((chessComponents[i][j]).getChessColor() != ChessColor.BLACK)) {
                            p = false;
                        }
                    } else {
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
        return a;
    }
}
