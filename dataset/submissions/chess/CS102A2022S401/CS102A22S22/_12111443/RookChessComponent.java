import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int left = getSource().getY();
        int right = 7 - getSource().getY();
        int up = getSource().getX();
        int down = 7 - getSource().getX();

        //to left
        for (int i = 1; i <= left; i++) {
            if (super.currentChessboard[getSource().getX()][getSource().getY() - i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));
            } else {
                if (super.currentChessboard[getSource().getX()][getSource().getY() - i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() - i));
                }
                break;
            }
        }
        //to right
        for (int i = 1; i <= right; i++) {
            if (super.currentChessboard[getSource().getX()][getSource().getY() + i].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));
            } else {
                if (super.currentChessboard[getSource().getX()][getSource().getY() + i].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX(), getSource().getY() + i));
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
                }
                break;
            }
        }
        //to down
        for (int i = 1; i <= down; i++) {
            if (super.currentChessboard[getSource().getX() + i][getSource().getY()].getClass().equals(EmptySlotComponent.class)) {
                canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
            } else {
                if (super.currentChessboard[getSource().getX() + i][getSource().getY()].getChessColor() != super.currentChessboard[getSource().getX()][getSource().getY()].getChessColor()) {
                    canMove.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
                }
                break;
            }
        }
        return canMove;
    }

    @Override
    public void setName() {
        if (super.getChessColor().equals(ChessColor.BLACK)) {
            super.name = 'R';
        } else
            super.name = 'r';
    }
}
