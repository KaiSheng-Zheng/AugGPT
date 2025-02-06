import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo2 = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() == 1) {
                if (getChessComponents()[2][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(2, getSource().getY()));
                }
                if (getChessComponents()[3][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(3, getSource().getY()));
                }
            } else {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                }
            }
            if (getSource().getY() == 0) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                }
            } else if (getSource().getY() == 7) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                }
            } else {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                }
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                }
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() == 6) {
                if (getChessComponents()[5][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(5, getSource().getY()));
                }
                if (getChessComponents()[4][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(4, getSource().getY()));
                }
            } else {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                }
            }
            if (getSource().getY() == 0) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                }
            } else if (getSource().getY() == 7) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                }
            } else {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                }
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                }
            }
        }
        return canMoveTo2;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {
            super.name = 'p';
        } else if (chessColor == ChessColor.BLACK) {
            super.name = 'P';
        }
    }
}