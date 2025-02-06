

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }
    public boolean check(){
        return (this.getSource().getX() == 1 && this.getChessColor() == ChessColor.BLACK)
                || (this.getSource().getX() == 6 && this.getChessColor() == ChessColor.WHITE);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int dx = 1;
        if (this.getChessColor() == ChessColor.WHITE) {
            dx = -1;
        }
        ChessboardPoint newPoint = getSource().offset(dx, 0);
        if (newPoint != null) {
            if (ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() == ChessColor.NONE) {
                list.add(newPoint);
            }
        }
        if (check()) {
            newPoint = getSource().offset(2 * dx, 0);
            if (newPoint != null) {
                if (ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() == ChessColor.NONE) {
                    list.add(newPoint);
                }
            }
        }
        newPoint = getSource().offset(dx, -1);
        if (newPoint != null) {
            if (ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() != ChessColor.NONE &&
                    ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() != getChessColor()) {
                list.add(newPoint);
            }
        }
        newPoint = getSource().offset(dx, 1);
        if (newPoint != null) {
            if (ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() != ChessColor.NONE &&
                    ConcreteChessGame.chesscomponents[newPoint.getX()][newPoint.getY()].getChessColor() != getChessColor()) {
                list.add(newPoint);
            }
        }
        return list;
    }
}
