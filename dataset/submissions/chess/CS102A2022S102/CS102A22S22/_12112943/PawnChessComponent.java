import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    private ChessColor color;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        if (c == 'P') {
            this.color = ChessColor.BLACK;
        } else if (c == 'p') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int i = ConcreteChessGame.xNow;
        int j = ConcreteChessGame.yNow;
        if (chessComponents[i][j].name == 'P') {
            if (i == 1) {
                if (chessComponents[i + 1][j].name == '_' && chessComponents[i + 2][j].name == '_')
                    result.add(new ChessboardPoint(i + 2, j));
            }
            if (i + 1 < 8) {
                if (chessComponents[i + 1][j].name == '_') {
                    result.add(new ChessboardPoint(i + 1, j));
                }
                if (j+1<8&&chessComponents[i + 1][j + 1].name >= 97) {
                    result.add(new ChessboardPoint(i + 1, j + 1));
                }
                if (j-1>=0&&chessComponents[i + 1][j - 1].name >= 97) {
                    result.add(new ChessboardPoint(i + 1, j - 1));
                }

            }
        } else if (chessComponents[i][j].name == 'p') {
            if (i == 6) {
                if (chessComponents[i - 1][j].name == '_' && chessComponents[i - 2][j].name == '_')
                    result.add(new ChessboardPoint(i - 2, j));
            }
            if (i - 1 >= 0) {
                if (chessComponents[i - 1][j].name == '_') {
                    result.add(new ChessboardPoint(i - 1, j));
                }
                if (j+1<8&&chessComponents[i - 1][j + 1].name <= 90) {
                    result.add(new ChessboardPoint(i - 1, j + 1));
                }
                if (j-1>=0&&chessComponents[i - 1][j - 1].name <= 90) {
                    result.add(new ChessboardPoint(i - 1, j - 1));

                }
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
