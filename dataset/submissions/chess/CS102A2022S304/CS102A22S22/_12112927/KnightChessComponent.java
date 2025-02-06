import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        if (x - 1 >= 0 && y + 2 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y + 2])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 1][y + 2])) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
        if (x + 2 <= 7 && y + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 2][y + 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 2][y + 1])) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y + 1));
            }
        }
        if (x + 1 <= 7 && y - 2 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y - 2])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 1][y - 2])) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 2][y - 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 2][y - 1])) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if (x - 2 >= 0 && y + 1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 2][y + 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 2][y + 1])) {
                chessboardPoints.add(new ChessboardPoint(x - 2, y + 1));
            }
        }
        if (x + 1 <= 7 && y + 2 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 1][y + 2])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 1][y + 2])) {
                chessboardPoints.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
        if (x + 2 <= 7 && y - 1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x + 2][y - 1])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x + 2][y - 1])) {
                chessboardPoints.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x - 1][y - 2])
                    || DifferentColorJudge(chessColor, ConcreteChessGame.getchessComponents[x - 1][y - 2])) {
                chessboardPoints.add(new ChessboardPoint(x - 1, y - 2));
            }
        }

        return chessboardPoints;
    }
}
