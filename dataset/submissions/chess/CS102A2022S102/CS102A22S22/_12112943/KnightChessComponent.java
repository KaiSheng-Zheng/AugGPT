import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        if (c == 'N') {
            this.color = ChessColor.BLACK;
        } else if (c == 'n') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int i = ConcreteChessGame.xNow;
        int j = ConcreteChessGame.yNow;
        if (chessComponents[i][j].name == 'N') {
            if (i - 2 >= 0 && j - 1 >= 0 && chessComponents[i - 2][j - 1].name > 90) {
                result.add(new ChessboardPoint(i - 2, j - 1));
            }
            if (i - 2 >= 0 && j + 1 < 8 && chessComponents[i - 2][j + 1].name > 90) {
                result.add(new ChessboardPoint(i - 2, j + 1));
            }
            if (i - 1 >= 0 && j - 2 >= 0 && chessComponents[i - 1][j - 2].name > 90) {
                result.add(new ChessboardPoint(i - 1, j - 2));
            }
            if (i - 1 >= 0 && j + 2 < 8 && chessComponents[i - 1][j + 2].name > 90) {
                result.add(new ChessboardPoint(i - 1, j + 2));
            }
            if (i + 1 < 8 && j - 2 >= 0 && chessComponents[i + 1][j - 2].name > 90) {
                result.add(new ChessboardPoint(i + 1, j - 2));
            }
            if (i + 1 < 8 && j + 2 < 8 && chessComponents[i + 1][j + 2].name > 90) {
                result.add(new ChessboardPoint(i + 1, j + 2));
            }
            if (i + 2 < 8 && j - 1 > 0 && chessComponents[i + 2][j - 1].name > 90) {
                result.add(new ChessboardPoint(i + 2, j - 1));
            }
            if (i + 2 < 8 && j + 1 < 8 && chessComponents[i + 2][j + 1].name > 90) {
                result.add(new ChessboardPoint(i + 2, j + 1));
            }

        } else if (chessComponents[i][j].name == 'n') {
            if (i - 2 >= 0 && j - 1 >= 0 && (chessComponents[i - 2][j - 1].name < 97 || chessComponents[i - 2][j - 1].name > 122)) {
                result.add(new ChessboardPoint(i - 2, j - 1));
            }
            if (i - 2 >= 0 && j + 1 < 8 && (chessComponents[i - 2][j + 1].name < 97 || chessComponents[i - 2][j + 1].name > 122)) {
                result.add(new ChessboardPoint(i - 2, j + 1));
            }
            if (i - 1 >= 0 && j - 2 >= 0 && (chessComponents[i - 1][j - 2].name < 97 || chessComponents[i - 1][j - 2].name > 122)) {
                result.add(new ChessboardPoint(i - 1, j - 2));
            }
            if (i - 1 >= 0 && j + 2 < 8 && (chessComponents[i - 1][j + 2].name < 97 || chessComponents[i - 1][j + 2].name > 122)) {
                result.add(new ChessboardPoint(i - 1, j + 2));
            }
            if (i + 1 < 8 && j - 2 >= 0 && (chessComponents[i + 1][j - 2].name < 97 || chessComponents[i + 1][j - 2].name > 122)) {
                result.add(new ChessboardPoint(i + 1, j - 2));
            }
            if (i + 1 < 8 && j + 2 < 8 && (chessComponents[i + 1][j + 2].name < 97 || chessComponents[i + 1][j + 2].name > 122)) {
                result.add(new ChessboardPoint(i + 1, j + 2));
            }
            if (i + 2 < 8 && j - 1 > 0 && (chessComponents[i + 2][j - 1].name < 97 || chessComponents[i + 2][j - 1].name > 122)) {
                result.add(new ChessboardPoint(i + 2, j - 1));
            }
            if (i + 2 < 8 && j + 1 < 8 && (chessComponents[i + 2][j + 1].name < 97 || chessComponents[i + 2][j + 1].name > 122)) {
                result.add(new ChessboardPoint(i + 2, j + 1));
            }
        }
        return result;
    }
}
