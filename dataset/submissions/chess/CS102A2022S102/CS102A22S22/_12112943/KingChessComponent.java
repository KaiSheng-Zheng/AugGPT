import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;
    public KingChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        if (c == 'K') {
            this.color = ChessColor.BLACK;
        } else if (c == 'k') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int i = ConcreteChessGame.xNow;
        int j = ConcreteChessGame.yNow;
        if (chessComponents[i][j].name == 'K') {
            if (i - 1 >= 0 && j - 1 >= 0 && chessComponents[i - 1][j - 1].name > 90) {
                result.add(new ChessboardPoint(i - 1, j - 1));
            }
            if (i - 1 >= 0 && chessComponents[i - 1][j].name > 90) {
                result.add(new ChessboardPoint(i - 1, j));
            }
            if (i - 1 >= 0 && j + 1 < 8 && chessComponents[i - 1][j + 1].name > 90) {
                result.add(new ChessboardPoint(i - 1, j + 1));
            }
            if (j - 1 >= 0 && chessComponents[i][j - 1].name > 90) {
                result.add(new ChessboardPoint(i, j - 1));
            }
            if (j + 1 < 8 && chessComponents[i][j + 1].name > 90) {
                result.add(new ChessboardPoint(i, j + 1));
            }
            if (i + 1 < 8 && j - 1 >= 0 && chessComponents[i + 1][j - 1].name > 90) {
                result.add(new ChessboardPoint(i + 1, j - 1));
            }
            if (i + 1 < 8 && chessComponents[i + 1][j].name > 90) {
                result.add(new ChessboardPoint(i + 1, j));
            }
            if (i + 1 < 8 && j + 1 < 8 && chessComponents[i + 1][j + 1].name > 90) {
                result.add(new ChessboardPoint(i + 1, j + 1));
            }

        } else if (chessComponents[i][j].name == 'k') {
            if (i - 1 >= 0 && j - 1 >= 0 && chessComponents[i - 1][j - 1].name < 97) {
                result.add(new ChessboardPoint(i - 1, j - 1));
            }
            if (i - 1 >= 0 && chessComponents[i - 1][j].name < 97) {
                result.add(new ChessboardPoint(i - 1, j));
            }
            if (i - 1 >= 0 && j + 1 < 8 && chessComponents[i - 1][j + 1].name <97) {
                result.add(new ChessboardPoint(i - 1, j + 1));
            }
            if (j - 1 >= 0 && chessComponents[i][j - 1].name < 97) {
                result.add(new ChessboardPoint(i, j - 1));
            }
            if (j + 1 < 8 && chessComponents[i][j + 1].name < 97) {
                result.add(new ChessboardPoint(i, j + 1));
            }
            if (i + 1 < 8 && j - 1 >= 0 && chessComponents[i + 1][j - 1].name < 97) {
                result.add(new ChessboardPoint(i + 1, j - 1));
            }
            if (i + 1 < 8 && chessComponents[i + 1][j].name <= 97) {
                result.add(new ChessboardPoint(i + 1, j));
            }
            if (i + 1 < 8 && j + 1 < 8 && chessComponents[i + 1][j + 1].name < 97) {
                result.add(new ChessboardPoint(i + 1, j + 1));
            }
        }
        return result;
    }
}
