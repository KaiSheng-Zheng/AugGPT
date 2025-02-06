import java.util.*;

public class PawnChessComponent extends ChessComponent{
    private int FirstStep;
    public PawnChessComponent(ChessColor color) {
        if(color==ChessColor.BLACK){
            name='P';
        }
        else if(color==ChessColor.WHITE){
            name='p';
        }
    }

    public int getFirstStep() {
        return FirstStep;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        int a = super.getSource().getX(), b = super.getSource().getY();

        if(super.getChessColor()==ChessColor.WHITE) {
            if (a == 6 && chessComponents[a-1][b].getChessColor() == ChessColor.NONE && chessComponents[a - 2][b].getChessColor() == ChessColor.NONE) {
                canMovePoints.add(new ChessboardPoint(a-1, b));
                canMovePoints.add(new ChessboardPoint(a-2, b));
            } else {
                if (a == 6 && chessComponents[a-1][b].getChessColor() == ChessColor.NONE && chessComponents[a - 2][b].getChessColor() == super.getChessColor()) {
                    canMovePoints.add(new ChessboardPoint(a-1, b));
                } else {
                    if (a != 6 && chessComponents[a-1][b].getChessColor() == ChessColor.NONE) {
                        canMovePoints.add(new ChessboardPoint(a-1, b));
                    } else {
                        if (b == 0 && chessComponents[a-1][b+1].getChessColor() == reverseChessColor(super.getChessColor())) {
                            canMovePoints.add(new ChessboardPoint(a-1, b+1));
                        } else {
                            if (b == 7 && chessComponents[a-1][b-1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                canMovePoints.add(new ChessboardPoint(a-1, b-1));
                            } else {
                                if (b < 7 && b > 0 && chessComponents[a-1][b+1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                    canMovePoints.add(new ChessboardPoint(a-1, b+1));
                                } else {
                                    if (b < 7 && b > 0 && chessComponents[a-1][b-1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                        canMovePoints.add(new ChessboardPoint(a-1, b-1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            if (a == 1 && chessComponents[a + 1][b].getChessColor() == ChessColor.NONE && chessComponents[a + 2][b].getChessColor() == ChessColor.NONE) {
                canMovePoints.add(new ChessboardPoint(a + 1, b));
                canMovePoints.add(new ChessboardPoint(a + 2, b));
            } else {
                if (a == 1 && chessComponents[a + 1][b].getChessColor() == ChessColor.NONE && chessComponents[a + 2][b].getChessColor() == super.getChessColor()) {
                    canMovePoints.add(new ChessboardPoint(a + 1, b));
                } else {
                    if (a != 1 && chessComponents[a + 1][b].getChessColor() == ChessColor.NONE) {
                        canMovePoints.add(new ChessboardPoint(a + 1, b));
                    } else {
                        if (b == 0 && chessComponents[a + 1][b + 1].getChessColor() == reverseChessColor(super.getChessColor())) {
                            canMovePoints.add(new ChessboardPoint(a + 1, b + 1));
                        } else {
                            if (b == 7 && chessComponents[a + 1][b - 1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                canMovePoints.add(new ChessboardPoint(a + 1, b - 1));
                            } else {
                                if (b < 7 && b > 0 && chessComponents[a + 1][b + 1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                    canMovePoints.add(new ChessboardPoint(a + 1, b + 1));
                                } else {
                                    if (b < 7 && b > 0 && chessComponents[a + 1][b - 1].getChessColor() == reverseChessColor(super.getChessColor())) {
                                        canMovePoints.add(new ChessboardPoint(a + 1, b - 1));
                                    }
                                }
                            }
                        }
                    }
                }
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
                        } else {
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
        } else {
            if (chessColor == ChessColor.WHITE) {
                return ChessColor.BLACK;
            } else {
                return ChessColor.NONE;
            }
        }
    }
}