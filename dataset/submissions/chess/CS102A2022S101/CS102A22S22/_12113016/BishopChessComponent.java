import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX() + i <= 7 && getSource().getY() + i <= 7) {
                if (getChesses()[getSource().getX() + i][getSource().getY() + i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                } else {
                    if (getChesses()[getSource().getX() + i][getSource().getY() + i].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX() - i >= 0 && getSource().getY() - i >= 0) {
                if (getChesses()[getSource().getX() - i][getSource().getY() - i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                } else {
                    if (getChesses()[getSource().getX() - i][getSource().getY() - i].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX() - i >= 0 && getSource().getY() + i <= 7) {
                if (getChesses()[getSource().getX() - i][getSource().getY() + i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                } else {
                    if (getChesses()[getSource().getX() - i][getSource().getY() + i].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= 7; i++) {
            if (getSource().getX() + i <= 7 && getSource().getY() - i >= 0) {
                if (getChesses()[getSource().getX() + i][getSource().getY() - i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                } else {
                    if (getChesses()[getSource().getX() + i][getSource().getY() - i].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        return chessboardPoints;
    }

    @Override
    public String toString() {
        return getChessColor() == ChessColor.WHITE ? "b" : "B";
    }

    @Override
    public void giveValueTo(ChessComponent target) {
        target = new BishopChessComponent();
        target.setChessColor(this.getChessColor());
        target.setSource(new ChessboardPoint(this.getSource().getX(), this.getSource().getY()));
    }
}
