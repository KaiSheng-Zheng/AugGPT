import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoint = new ArrayList<>();
        ConcreteChessGame pawn = new ConcreteChessGame();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pawn.getChess(getSource().getX(), getSource().getY()).getChessColor() == ChessColor.WHITE) {

                    if (getSource().getX() == 6 && getSource().getY() == j) {
                        if (i == 5 || i == 4) {
                            for (int row = getSource().getX() - 1; row >= i; row--) {
                                if (pawn.getChess(row, getSource().getY()).getChessColor() == ChessColor.NONE) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }

                        }
                    } else if (i == getSource().getX() - 1 && j == getSource().getY()) {
                        if (pawn.getChess(i, getSource().getY()).getChessColor() == ChessColor.NONE) {
                            canMoveToPoint.add(new ChessboardPoint(i, j));
                        }
                    } else if (i == getSource().getX() - 1 && j + 1 == getSource().getY() && pawn.getChess(i, j).getChessColor() == ChessColor.BLACK) {
                        canMoveToPoint.add(new ChessboardPoint(i, j));//chizi
                    } else if (i == getSource().getX() - 1 && j - 1 == getSource().getY() && pawn.getChess(i, j).getChessColor() == ChessColor.BLACK) {
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    } //
                } else {

                    if (getSource().getX() == 1 && getSource().getY() == j) {
                        if (i == 2 || i == 3) {
                            for (int row = getSource().getX() + 1; row <= i; row++) {
                                if (pawn.getChess(row, getSource().getY()).getChessColor() !=
                                        pawn.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                                    canMoveToPoint.add(new ChessboardPoint(i, j));
                                }
                            }

                        }
                    } else if (i == getSource().getX() + 1 && j == getSource().getY()) {
                        if (pawn.getChess(i, j).getChessColor() !=
                                pawn.getChess(getSource().getX(), getSource().getY()).getChessColor()) {
                            canMoveToPoint.add(new ChessboardPoint(i, j));
                        }
                    } else if (pawn.getChess(getSource().getX(), getSource().getY()).getChessColor() == ChessColor.BLACK
                            && i - 1 == getSource().getX() && j + 1 == getSource().getY() &&   //........
                            pawn.getChess(i, j).getChessColor() == ChessColor.WHITE) {
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    } else if (pawn.getChess(getSource().getX(), getSource().getY()).getChessColor() == ChessColor.BLACK
                            && i - 1 == getSource().getX() && j - 1 == getSource().getY() &&
                            pawn.getChess(i, j).getChessColor() == ChessColor.WHITE) {
                        canMoveToPoint.add(new ChessboardPoint(i, j));
                    }//.........

                }

            }
        }return canMoveToPoint;
    }
}
