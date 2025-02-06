import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            name = 'K';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int a = super.getSource().getX(), b = super.getSource().getY();
        if (a + 1 <= 7 && a - 1 > -1 && b + 1 <= 7 && b - 1 > -1) {
            for (int i = -1; i < 2; i++) {
                if (chessComponents[a + i][b + i].getChessColor() != super.getChessColor()) {
                    canMovePoints.add(new ChessboardPoint(a + i, b + i));
                }
            }
        } else {
            if (a + 1 <= 7 && a - 1 > -1 && b - 1 < 0) {
                for (int i = -1; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (chessComponents[a + i][b + j].getChessColor() != super.getChessColor()) {
                            canMovePoints.add(new ChessboardPoint(a + i, b + j));
                        }
                    }
                }
            } else {
                if (a + 1 <= 7 && a - 1 > -1 && b + 1 > 7) {
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 1; j++) {
                            if (chessComponents[a + i][b + j].getChessColor() != super.getChessColor()) {
                                canMovePoints.add(new ChessboardPoint(a + i, b + j));
                            }
                        }
                    }
                } else {
                    if (a - 1 < 0 && b + 1 <= 7 && b - 1 > -1) {
                        for (int i = 0; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                if (chessComponents[a + i][b + j].getChessColor() != super.getChessColor()) {
                                    canMovePoints.add(new ChessboardPoint(a + i, b + j));
                                }
                            }
                        }
                    } else if (a + 1 >= 8 && b + 1 < 8 && b - 1 >= 0) {
                        for (int i = -1; i < 1; i++) {
                            for (int j = -1; j < 2; j++) {
                                if (chessComponents[a + i][b + j].getChessColor() != super.getChessColor()) {
                                    canMovePoints.add(new ChessboardPoint(a + i, b + j));
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