import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color) {
        if (color == ChessColor.BLACK) {
            name = 'N';
        }
        else if (color == ChessColor.WHITE) {
            name = 'n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int a = super.getSource().getX(), b = super.getSource().getY();

        if (a > 1 && a < 10 && b > 0 && b < 9 && chessComponents[a-2][b-1].getChessColor() != super.getChessColor()) {
            canMovePoints.add(new ChessboardPoint(a - 2, b - 1));
        } else {
            if (a > 1 && a < 10 && b > -2 && b < 7 && chessComponents[a-2][b+1].getChessColor() != super.getChessColor()) {
                canMovePoints.add(new ChessboardPoint(a-2, b+1));
            } else {
                if (a > 0 && a < 9 && b > 1 && b < 10 && chessComponents[a-1][b-2].getChessColor() != super.getChessColor()) {
                    canMovePoints.add(new ChessboardPoint(a - 1, b - 2));
                } else {
                    if (a > 0 && a < 9 && b > -3 && b < 6 && chessComponents[a-1][b+2].getChessColor() != super.getChessColor()) {
                        canMovePoints.add(new ChessboardPoint(a - 1, b + 2));
                    } else {
                        if (a > -2 && a < 7 && b > 1 && b < 10 && chessComponents[a+1][b-2].getChessColor() != super.getChessColor()) {
                            canMovePoints.add(new ChessboardPoint(a + 1, b - 2));
                        } else {
                            if (a > -2 && a < 7 && b > -3 && b  < 6 && chessComponents[a+1][b+2].getChessColor() != super.getChessColor()) {
                                canMovePoints.add(new ChessboardPoint(a + 1, b + 2));
                            } else {
                                if (a > -3 && a < 6 && b > 0 && b < 9 && chessComponents[a+2][b-1].getChessColor() != super.getChessColor()) {
                                    canMovePoints.add(new ChessboardPoint(a+2, b-1));
                                } else {
                                    if (a > -3 && a < 6 && b > -2 && b < 7 && chessComponents[a+2][b+1].getChessColor() != super.getChessColor()) {
                                        canMovePoints.add(new ChessboardPoint(a+2, b+1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return canMovePoints;
    }
}