import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();

        if (this.getChessColor() == ChessColor.BLACK) {
            if (x == 1) {
                if (chessComponents[2][y].getChessColor() == ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(2, y));
                    if (chessComponents[3][y].getChessColor() == ChessColor.NONE) {
                        canMovePoints.add(new ChessboardPoint(3, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[2][y - 1].getChessColor() == ChessColor.WHITE) {
                        canMovePoints.add(new ChessboardPoint(2, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[2][y + 1].getChessColor() == ChessColor.WHITE) {
                        canMovePoints.add(new ChessboardPoint(2, y + 1));
                    }
                }
            } else if (x < 7) {
                if (chessComponents[x + 1][y].getChessColor() == ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(x + 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                        canMovePoints.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                        canMovePoints.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            }
        } else {
            if (x == 6) {
                if (chessComponents[5][y].getChessColor() == ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(5, y));
                    if (chessComponents[4][y].getChessColor() == ChessColor.NONE) {
                        canMovePoints.add(new ChessboardPoint(4, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[5][y - 1].getChessColor() == ChessColor.BLACK) {
                        canMovePoints.add(new ChessboardPoint(5, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[5][y + 1].getChessColor() == ChessColor.BLACK) {
                        canMovePoints.add(new ChessboardPoint(5, y + 1));
                    }
                }
            } else if (x > 0) {
                if (chessComponents[x - 1][y].getChessColor() == ChessColor.NONE) {
                    canMovePoints.add(new ChessboardPoint(x - 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                        canMovePoints.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                        canMovePoints.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
            }
        }
        return canMovePoints;
    }

}