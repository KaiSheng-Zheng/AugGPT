import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(chessboardPoint, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        int m = 0;
        int k = 0;
        if(chessComponents[getSource().getX()][getSource().getY()].getChessColor().equals(ChessColor.BLACK)) {
            if (m == 0) {
                if (chessComponents[getSource().getX() + 1][getSource().getY()].name == '_') {
                    if (getSource().offset(1, 0) != null) {
                        if (getSource().offset(1, 0) != null) {
                            chessboardPoints.add(getSource().offset(1, 0));
                        }
                    }
                    if (chessComponents[getSource().getX() + 2][getSource().getY()].name == '_') {
                        if (getSource().offset(2, 0) != null) {
                            chessboardPoints.add(getSource().offset(2, 0));
                        }
                    }
                }
            } else {
                if (chessComponents[getSource().getX() + 1][getSource().getY()].name == '_') {
                    if (getSource().offset(1, 0) != null) {
                        chessboardPoints.add(getSource().offset(1, 0));
                    }
                }
            }
            if (chessComponents[getSource().offset(1, 1).getX()][getSource().offset(1, 1).getY()].chessColor.equals(
                    ChessColor.WHITE)) {
                if (getSource().offset(1, 1) != null) {
                    chessboardPoints.add(getSource().offset(1, 1));
                }
            }
            if (chessComponents[getSource().offset(1, -1).getX()][getSource().offset(1, -1).getY()].chessColor.equals(
                    ChessColor.WHITE)) {
                if (getSource().offset(1, -1) != null) {
                    chessboardPoints.add(getSource().offset(1, -1));
                }
            }m++;
        }if(chessComponents[getSource().getX()][getSource().getY()].getChessColor().equals(ChessColor.WHITE)) {
            if (k == 0) {
                if (chessComponents[getSource().getX() - 1][getSource().getY()].name == '_') {
                    if (getSource().offset(-1, 0) != null) {
                        if (getSource().offset(-1, 0) != null) {
                            chessboardPoints.add(getSource().offset(-1, 0));
                        }
                    }
                    if (chessComponents[getSource().getX() - 2][getSource().getY()].name == '_') {
                        if (getSource().offset(-2, 0) != null) {
                            chessboardPoints.add(getSource().offset(-2, 0));
                        }
                    }
                }
            } else {
                if (chessComponents[getSource().getX() - 1][getSource().getY()].name == '_') {
                    if (getSource().offset(-1, 0) != null) {
                        chessboardPoints.add(getSource().offset(-1, 0));
                    }
                }
            }
            if (chessComponents[getSource().offset(-1, -1).getX()][getSource().offset(-1, -1).getY()].chessColor.equals(
                    ChessColor.BLACK)) {
                if (getSource().offset(-1, -1) != null) {
                    chessboardPoints.add(getSource().offset(-1, -1));
                }
            }
            if (chessComponents[getSource().offset(-1, 1).getX()][getSource().offset(-1, 1).getY()].chessColor.equals(
                    ChessColor.BLACK)) {
                if (getSource().offset(-1, 1) != null) {
                    chessboardPoints.add(getSource().offset(-1, 1));
                }
            }k++;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (ChessboardPoint t : chessboardPoints) {
                    if (t.getX() == i && t.getY() == j)
                        getCanMovePoints.add(new ChessboardPoint(i, j));
                }
            }
        }
        return getCanMovePoints;
    }
}