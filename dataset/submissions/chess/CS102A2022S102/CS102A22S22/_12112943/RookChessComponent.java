import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        if (c == 'R') {
            this.color = ChessColor.BLACK;
        } else if (c == 'r') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int i = ConcreteChessGame.xNow;
        int j = ConcreteChessGame.yNow;
        if (chessComponents[i][j].name == 'R') {
            for (int k = 1; k < 8; k++) {
                if (i - k < 0) {
                    break;
                }
                if (chessComponents[i - k][j].name <= 90) {
                    break;
                }
                if (chessComponents[i - k][j].name >= 97) {
                    result.add(new ChessboardPoint(i - k, j));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j));
            }
            for (int k = 1; k < 8; k++) {
                if (j - k < 0) {
                    break;
                }
                if (chessComponents[i][j - k].name <= 90) {
                    break;
                }
                if (chessComponents[i][j - k].name >= 97) {
                    result.add(new ChessboardPoint(i, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (j + k > 7) {
                    break;
                }
                if (chessComponents[i][j + k].name <= 90) {
                    break;
                }
                if (chessComponents[i][j + k].name >= 97) {
                    result.add(new ChessboardPoint(i, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i, j + k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7) {
                    break;
                }
                if (chessComponents[i + k][j].name <= 90) {
                    break;
                }
                if (chessComponents[i + k][j].name >= 97) {
                    result.add(new ChessboardPoint(i + k, j));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j));
            }

        } else if (chessComponents[i][j].name == 'r') {
            for (int k = 1; k < 8; k++) {
                if (i - k < 0) {
                    break;
                }
                if (chessComponents[i - k][j].name >= 97) {
                    break;
                }
                if (chessComponents[i - k][j].name <= 90) {
                    result.add(new ChessboardPoint(i - k, j));
                    break;
                }
                result.add(new ChessboardPoint(i - k, j));
            }
            for (int k = 1; k < 8; k++) {
                if (j - k < 0) {
                    break;
                }
                if (chessComponents[i][j - k].name >= 97) {
                    break;
                }
                if (chessComponents[i][j - k].name <= 90) {
                    result.add(new ChessboardPoint(i, j - k));
                    break;
                }
                result.add(new ChessboardPoint(i, j - k));
            }
            for (int k = 1; k < 8; k++) {
                if (j + k > 7) {
                    break;
                }
                if (chessComponents[i][j + k].name >= 97) {
                    break;
                }
                if (chessComponents[i][j + k].name <= 90) {
                    result.add(new ChessboardPoint(i, j + k));
                    break;
                }
                result.add(new ChessboardPoint(i, j + k));
            }
            for (int k = 1; k < 8; k++) {
                if (i + k > 7) {
                    break;
                }
                if (chessComponents[i + k][j].name >= 97) {
                    break;
                }
                if (chessComponents[i + k][j].name <= 90) {
                    result.add(new ChessboardPoint(i + k, j));
                    break;
                }
                result.add(new ChessboardPoint(i + k, j));
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
