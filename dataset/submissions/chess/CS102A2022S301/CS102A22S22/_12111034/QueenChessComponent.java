import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoint = new ArrayList<>();
        ConcreteChessGame queen = new ConcreteChessGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSource().getX() == i) {
                    int row = getSource().getX();
                    for (int col = Math.min(getSource().getY(), j) + 1;
                         col < Math.max(getSource().getY(), j); col++) {
                        if (queen.getChess(row, col).getChessColor() !=
                                queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                            canMoveToPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                } else if (getSource().getY() == j) {
                    int col = getSource().getY();
                    for (int row = Math.min(getSource().getX(), i) + 1;
                         row < Math.max(getSource().getX(), i); row++) {
                        if (queen.getChess(row, col).getChessColor() !=
                                queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                            canMoveToPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                } else { // Not on the same row or the same column.
                    boolean low_left = i - getSource().getX() == getSource().getY() - j;
                    boolean low_right = i - getSource().getX() == j - getSource().getY();
                    boolean up_left = getSource().getX() - i == getSource().getY() - j;
                    boolean up_right = getSource().getX() - i == j - getSource().getY();
                    if (getSource().getX() < i) {
                        if (getSource().getY() > j & low_left) {
                            for (int a = 1; a < getSource().getY() - j; a++) {
                                if (queen.getChess(getSource().getX() + a, getSource().getY() - a).getChessColor() !=
                                        queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }
                        } else if (getSource().getY() < j & low_right) {
                            for (int a = 1; a < j - getSource().getY(); a++) {
                                if (queen.getChess(getSource().getX() + a, getSource().getY() + a).getChessColor() !=
                                        queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    } else if (getSource().getX() > i) {
                        if (getSource().getY() > j & up_left) {
                            for (int a = 1; i < getSource().getY() - j; a++) {
                                if (queen.getChess(getSource().getX() - a, getSource().getY() - a).getChessColor() !=
                                        queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }
                        } else if (getSource().getY() < j & up_right) {
                            for (int a = 1; a < j - getSource().getY(); a++) {
                                if (queen.getChess(getSource().getX() - a, getSource().getY() + a).getChessColor() !=
                                        queen.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }
                        }
                    }

                }
            }
        }return canMoveToPoint;
    }
}
