import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() == 1) {
                if (super.currentChessboard[getSource().getX() + 1][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                    canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                }
                if (super.currentChessboard[getSource().getX() + 2][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                    canMove.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()));
                }
                if (getSource().getY() < 7) {
                    if (!super.currentChessboard[getSource().getX() + 1][getSource().getY() + 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(getChessColor())) {
                        canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                }
                if (getSource().getY() > 0) {
                    if (!super.currentChessboard[getSource().getX() + 1][getSource().getY() - 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(getChessColor())) {
                        canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
            } else {
                if (getSource().getX() < 7) {
                    if (super.currentChessboard[getSource().getX() + 1][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                        canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    }
                    if (getSource().getY() < 7) {
                        if (!super.currentChessboard[getSource().getX() + 1][getSource().getY() + 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() + 1][getSource().getY() + 1].getChessColor().equals(getChessColor())) {
                            canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                        }
                    }
                    if (getSource().getY() > 0) {
                        if (!super.currentChessboard[getSource().getX() + 1][getSource().getY() - 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() + 1][getSource().getY() - 1].getChessColor().equals(getChessColor())) {
                            canMove.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                        }
                    }
                }
            }

        } else {
            if (getSource().getX() == 6) {
                if (super.currentChessboard[getSource().getX() - 1][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                    canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                }
                if (super.currentChessboard[getSource().getX() - 2][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                    canMove.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()));
                }
                if (getSource().getY() < 7) {
                    if (!super.currentChessboard[getSource().getX() - 1][getSource().getY() + 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(getChessColor())) {
                        canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                }
                if (getSource().getY() > 0) {
                    if (!super.currentChessboard[getSource().getX() - 1][getSource().getY() - 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(getChessColor())) {
                        canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }
            } else {
                if (getSource().getX() > 0) {
                    if (super.currentChessboard[getSource().getX() - 1][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                        canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                    }
                    if (getSource().getY() < 7) {
                        if (!super.currentChessboard[getSource().getX() - 1][getSource().getY() + 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() - 1][getSource().getY() + 1].getChessColor().equals(getChessColor())) {
                            canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                        }
                    }
                    if (getSource().getY() > 0) {
                        if (!super.currentChessboard[getSource().getX() - 1][getSource().getY() - 1].getClass().equals(EmptySlotComponent.class) && !super.currentChessboard[getSource().getX() - 1][getSource().getY() - 1].getChessColor().equals(getChessColor())) {
                            canMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                        }
                    }
                }
            }

        }
        return canMove;

    }

    @Override
    public void setName() {
        if (super.getChessColor().equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else
            super.name = 'p';
    }

}
