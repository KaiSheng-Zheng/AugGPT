import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
    public PawnChessComponent(){}


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        boolean isBlack = this.getChessColor().equals(ChessColor.BLACK);
        if(isBlack) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i - X == 1 && j == Y && (chessComponents[i][j].getChessColor().equals(ChessColor.NONE))) {
                        canMoveTo.add(new ChessboardPoint(i, j));
                        if (X == 1 && (chessComponents[3][j].getChessColor().equals(ChessColor.NONE))) {
                            canMoveTo.add(new ChessboardPoint(3, j));
                        }
                    }
                    if (i - X == 1 && Math.abs(j - Y) == 1 && (chessComponents[i][j].getChessColor().equals(ChessColor.WHITE))) {
                        canMoveTo.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i - X == -1 && j == Y && (chessComponents[i][j].getChessColor().equals(ChessColor.NONE))) {
                        canMoveTo.add(new ChessboardPoint(i, j));
                        if (X == 6 && (chessComponents[4][j].getChessColor().equals(ChessColor.NONE))) {
                            canMoveTo.add(new ChessboardPoint(4, j));
                        }
                    }
                    if (X - i == 1 && Math.abs(j - Y) == 1 && (chessComponents[i][j].getChessColor().equals(ChessColor.BLACK))) {
                        canMoveTo.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return canMoveTo;
    }
}