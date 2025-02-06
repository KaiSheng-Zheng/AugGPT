import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor color) {
        if (color == ChessColor.BLACK) {
            name = 'R';
        }
        else if (color == ChessColor.WHITE) {
            name = 'r';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int a = super.getSource().getX(), b= super.getSource().getY();
        for (int i = 1; i <= a; i++) {
            if (chessComponents[a-i][b] instanceof EmptySlotComponent) {
                canMovePoints.add(new ChessboardPoint(a-i, b));
            }
            if (chessComponents[a-i][b].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMovePoints.add(new ChessboardPoint(a-i, b));
                break;
            }
            if (chessComponents[a-i][b].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        for (int i = 1; a + i < 8; i++) {
            if (chessComponents[a+i][b] instanceof EmptySlotComponent) {
                canMovePoints.add(new ChessboardPoint(a+i, b));
            }
            if (chessComponents[a+i][b].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMovePoints.add(new ChessboardPoint(a+i, b));
                break;
            }
            if (chessComponents[a+i][b].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        for (int i = 1; i <= b; i++) {
            if (chessComponents[a][b-i] instanceof EmptySlotComponent) {
                canMovePoints.add(new ChessboardPoint(a, b-i));
            }
            if (chessComponents[a][b-i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMovePoints.add(new ChessboardPoint(a, b-i));
                break;
            }
            if (chessComponents[a][b-i].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        for (int i = 1; b+i < 8; i++) {
            if (chessComponents[a][b+i] instanceof EmptySlotComponent) {
                canMovePoints.add(new ChessboardPoint(a, b+i));
            }
            if (chessComponents[a][b+i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMovePoints.add(new ChessboardPoint(a, b+i));
                break;
            }
            if (chessComponents[a][b+i].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else {
                    if (o1.getX() == o2.getX()) {
                        if (o1.getY() > o2.getY()) {
                            return 1;
                        }
                        else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            }
        });
        return canMovePoints;
    }

    public ChessColor reverseChessColor(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        }
        if (chessColor == ChessColor.WHITE) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.NONE;
        }
    }
}