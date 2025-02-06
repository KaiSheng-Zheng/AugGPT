import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        switch (super.getChessColor()) {
            case WHITE -> {
                if (x - 1 >= 0 && EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y])) {
                    if (x == 6 && EmptyJudge(ConcreteChessGame.getchessComponents[x - 2][y])) {
                        chessboardPoints.add(new ChessboardPoint(x - 2, y));
                        chessboardPoints.add(new ChessboardPoint(x - 1, y));
                    } else {
                        chessboardPoints.add(new ChessboardPoint(x - 1, y));
                    }
                }
                if ((x - 1 >= 0 && y + 1 <= 7) && ConcreteChessGame.getchessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    chessboardPoints.add(new ChessboardPoint(x - 1, y + 1));
                }
                if ((x - 1 >= 0 && y - 1 >= 0) && ConcreteChessGame.getchessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    chessboardPoints.add(new ChessboardPoint(x - 1, y - 1));
                }
                return chessboardPoints;
            }
            case BLACK -> {
                if (x + 1 <= 7 && EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y])) {
                    if (x == 1 && EmptyJudge(ConcreteChessGame.getchessComponents[x + 2][y])) {
                        chessboardPoints.add(new ChessboardPoint(x + 2, y));
                        chessboardPoints.add(new ChessboardPoint(x + 1, y));
                    } else {
                        chessboardPoints.add(new ChessboardPoint(x + 1, y));
                    }
                }
                if ((x + 1 <= 7 && y + 1 <= 7) && ConcreteChessGame.getchessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    chessboardPoints.add(new ChessboardPoint(x + 1, y + 1));
                }
                if ((x + 1 <= 7 && y - 1 >= 0) && ConcreteChessGame.getchessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    chessboardPoints.add(new ChessboardPoint(x + 1, y - 1));
                }
                return chessboardPoints;
            }
            default -> {
                return chessboardPoints;
            }
        }
    }
}
