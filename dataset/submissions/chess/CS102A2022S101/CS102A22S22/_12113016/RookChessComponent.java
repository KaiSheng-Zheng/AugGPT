import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (getSource().getX() != 0) {
            for (int i = getSource().getX() - 1; i >= 0; i--) {
                if (getChesses()[i][getSource().getY()] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(i, getSource().getY()));
                } else {
                    if (getChesses()[i][getSource().getY()].getChessColor() != getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    }
                    break;
                }
            }
        }


            for (int i = getSource().getX() + 1; i <= 7; i++) {
                if (getChesses()[i][getSource().getY()] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(i, getSource().getY()));
                } else {
                    if (getChesses()[i][getSource().getY()].getChessColor() != getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    }
                    break;
                }
            }


            for (int i = getSource().getY() - 1; i >= 0; i--) {
                if (getChesses()[getSource().getX()][i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX(), i));
                } else {
                    if (getChesses()[getSource().getX()][i].getChessColor() != getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    }
                    break;
                }
            }


        if (getSource().getY() != 7) {
            for (int i = getSource().getY() + 1; i <= 7; i++) {
                if (getChesses()[getSource().getX()][i] instanceof EmptySlotComponent) {
                    chessboardPoints.add(new ChessboardPoint(getSource().getX(), i));
                } else {
                    if (getChesses()[getSource().getX()][i].getChessColor() != getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    }
                    break;
                }
            }
        }



        return chessboardPoints;
}

    @Override
    public String toString() {
        return getChessColor() == ChessColor.WHITE ? "r" : "R";
    }

    @Override
    public void giveValueTo(ChessComponent target) {
        target = new RookChessComponent();
        target.setChessColor(this.getChessColor());
        target.setSource(new ChessboardPoint(this.getSource().getX(), this.getSource().getY()));
    }
}
