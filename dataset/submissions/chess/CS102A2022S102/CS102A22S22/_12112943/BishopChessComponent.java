import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        if (c == 'B') {
            this.color = ChessColor.BLACK;
        } else if (c == 'b') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int i = ConcreteChessGame.xNow;
        int j = ConcreteChessGame.yNow;
        if (chessComponents[i][j].name == 'B') {
            for (int k = 1; k < 8; k++) {
                if (i - k < 0 || j - k < 0) {
                    break;
                }
                if (chessComponents[i - k][j - k].name <= 90) {
                    break;
                }
                if (chessComponents[i - k][j - k].name >= 97) {
                    result.add(new ChessboardPoint(i - k, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (i - k < 0 || j + k > 7) {
                    break;
                }
                if (chessComponents[i - k][j + k].name <= 90) {
                    break;
                }
                if (chessComponents[i - k][j + k].name >= 97) {
                    result.add(new ChessboardPoint(i - k, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j + k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7 || j - k < 0) {
                    break;
                }
                if (chessComponents[i + k][j - k].name <= 90) {
                    break;
                }
                if (chessComponents[i + k][j - k].name >= 97) {
                    result.add(new ChessboardPoint(i + k, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7 || j + k > 7) {
                    break;
                }
                if (chessComponents[i + k][j + k].name <= 90) {
                    break;
                }
                if (chessComponents[i + k][j + k].name >= 97) {
                    result.add(new ChessboardPoint(i + k, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j + k));
            }


        } else if (chessComponents[i][j].name == 'b') {
            for (int k = 1; k < 8; k++) {
                if (i - k < 0 || j - k < 0) {
                    break;
                }
                if (chessComponents[i - k][j - k].name >= 97) {
                    break;
                }
                if (chessComponents[i - k][j - k].name <= 90) {
                    result.add(new ChessboardPoint(i - k, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (i - k < 0 || j + k > 7) {
                    break;
                }
                if (chessComponents[i - k][j + k].name >= 97) {
                    break;
                }
                if (chessComponents[i - k][j + k].name <= 90) {
                    result.add(new ChessboardPoint(i - k, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j + k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7 || j - k < 0) {
                    break;
                }
                if (chessComponents[i + k][j - k].name >= 97) {
                    break;
                }
                if (chessComponents[i + k][j - k].name <= 90) {
                    result.add(new ChessboardPoint(i + k, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7 || j + k > 7) {
                    break;
                }
                if (chessComponents[i + k][j + k].name >= 97) {
                    break;
                }
                if (chessComponents[i + k][j + k].name <= 90) {
                    result.add(new ChessboardPoint(i + k, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j + k));
            }
        }
        Collections.sort(result, new Comparator<ChessboardPoint>() {

            @Override
            public int compare(ChessboardPoint p1, ChessboardPoint p2) {

                if (p1.getX() != p2.getX()) {
                    return p1.getX() - p2.getX();
                } else {
                    return p1.getY() - p2.getY();
                }
            }

        });
        return result;
    }
}
