import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int left = getSource().getY();
        int right = 7 - getSource().getY();
        int up = getSource().getX();
        int down = 7 - getSource().getX();

        //to left-up
        for (int i = 1; i <= Math.min(left, up); i++) {
            if (super.currentChessboard[getSource().getX() - i][getSource().getY() - i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
            } else {
                if (super.currentChessboard[getSource().getX() - i][getSource().getY() - i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                }
                break;
            }
        }
        //to up
        for (int i = 1; i <= up; i++) {
            if (super.currentChessboard[getSource().getX() - i][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));
            } else {
                if (super.currentChessboard[getSource().getX() - i][getSource().getY()].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY()));

                } break;
            }
        }
        //to right-up
        for (int i = 1; i <= Math.min(right, up); i++) {
            if (super.currentChessboard[getSource().getX() - i][getSource().getY() + i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
            } else {
                if (super.currentChessboard[getSource().getX() - i][getSource().getY() + i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));

                }break;
            }
        }
        //to left
        for (int i = 1; i <= left; i++) {
            if (super.currentChessboard[getSource().getX()][getSource().getY() - i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));
            } else {
                if (super.currentChessboard[getSource().getX()][getSource().getY() - i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));

                }break;
            }
        }

        //to right
        for (int i = 1; i <= right; i++) {
            if (super.currentChessboard[getSource().getX()][getSource().getY() + i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));
            } else {
                if (super.currentChessboard[getSource().getX()][getSource().getY() + i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));

                }break;
            }
        }
        //to left-down
        for (int i = 1; i <= Math.min(left, down); i++) {
            if (super.currentChessboard[getSource().getX() + i][getSource().getY() - i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
            } else {
                if (super.currentChessboard[getSource().getX() + i][getSource().getY() - i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));

                } break;
            }
        }
        //to down
        for (int i = 1; i <= down; i++) {
            if (super.currentChessboard[getSource().getX() + i][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
            } else {
                if (super.currentChessboard[getSource().getX() + i][getSource().getY()].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));

                }break;
            }
        }

        //to right-down
        for (int i = 1; i <= Math.min(right, down); i++) {
            if (super.currentChessboard[getSource().getX() + i][getSource().getY() + i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
            } else {
                if (super.currentChessboard[getSource().getX() + i][getSource().getY() + i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));

                } break;
            }
        }

        return canMove;
    }

    @Override
    public void setName() {
        if (super.getChessColor().equals(ChessColor.BLACK)) {
            super.name = 'Q';
        } else
            super.name = 'q';
    }
}
