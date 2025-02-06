import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ChessColor chessColor = super.getChessColor();
        if (y + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x][y + 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x][y + 1])) {
                chessboardPoints.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (x + 1 <= 7 && y + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y + 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 1][y + 1])) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y + 1));
            }
        }
        if (x + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 1][y])) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y));
            }
        }
        if (x + 1 <= 7 && y - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y - 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 1][y - 1])) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y - 1));
            }
        }
        if (y - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x][y - 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x][y - 1])) {
                chessboardPoints.add(new ChessboardPoint(x, y - 1));
            }
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y - 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 1][y - 1])) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        if (x - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 1][y])) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y));
            }
        }
        if (x - 1 >= 0 && y + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y + 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 1][y + 1])) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        return chessboardPoints;
    }
}
