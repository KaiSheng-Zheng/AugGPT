import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoint = new ArrayList<>();
        ConcreteChessGame bishop = new ConcreteChessGame();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean low_left = i - getSource().getX() == getSource().getY() - j;
                boolean low_right = i - getSource().getX() == j - getSource().getY();
                boolean up_left = getSource().getX() - i == getSource().getY() - j;
                boolean up_right = getSource().getX() - i == j - getSource().getY();

                if (getSource().getX() < i) {
                    if (getSource().getY() > j & low_left) {
                        for (int a = 1; a < getSource().getY() - j; a++) {
                            if (bishop.getChess(getSource().getX() + i, getSource().getY() - i).getChessColor() !=
                                    bishop.getChess(getSource().getX(),getSource().getY()).getChessColor() ) {
                                canMoveToPoint.add(new ChessboardPoint(i, j));
                            }
                        }
                    } else if (getSource().getY() < j & low_right) {
                        for (int a = 1; i < j - getSource().getY(); i++) {
                            if (bishop.getChess(getSource().getX() + i, getSource().getY() + i).getChessColor() !=
                                    bishop.getChess(getSource().getX(),getSource().getY()).getChessColor()) {
                                canMoveToPoint.add(new ChessboardPoint(i, j));
                            }
                        }
                    }
                } else if (getSource().getX() > i) {
                    if (getSource().getY() > j & up_left) {
                        for (int a = 1; i < getSource().getY() - j; i++) {
                            if (bishop.getChess(getSource().getX() - i, getSource().getY() - i).getChessColor() !=
                                    bishop.getChess(getSource().getX(),getSource().getY()).getChessColor()) {
                                canMoveToPoint.add(new ChessboardPoint(i, j));
                            }
                        }
                    } else if (getSource().getY() < j & up_right) {
                        for (int a = 1; i < j - getSource().getY(); i++) {
                            if (bishop.getChess(getSource().getX() - i, getSource().getY() + i).getChessColor() !=
                                    bishop.getChess(getSource().getX(),getSource().getY()).getChessColor()) {
                                canMoveToPoint.add(new ChessboardPoint(i, j));
                            }
                        }
                    }

                }
            }
        }
        return canMoveToPoint;
    }
}
