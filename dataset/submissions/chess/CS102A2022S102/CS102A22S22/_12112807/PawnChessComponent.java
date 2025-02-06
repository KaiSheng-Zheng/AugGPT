import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    private ChessColor color;
    private ChessComponent[][] chessComponents;
    private int a = 1;

    public PawnChessComponent(char cc, ChessComponent[][] chessComponents) {
        this.name = cc;
        if (cc == 'P') {
            a = 3;
            this.color = ChessColor.BLACK;
        } else if (cc == 'p') {
            this.color = ChessColor.WHITE;
            a = 3;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        int ii = ConcreteChessGame.xNow1;
        a = 3;
        int jj = ConcreteChessGame.yNow2;
        if (chessComponents[ii][jj].name == 'P') {
            if (ii == 1) {
                if (chessComponents[ii + 1][jj].name == '_' && chessComponents[ii + 2][jj].name == '_')
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii + 2, jj));
            }
            if (ii + 1 < 8) {
                if (chessComponents[ii + 1][jj].name == '_') {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii + 1, jj));
                }
                if (jj+1<8&&chessComponents[ii + 1][jj + 1].name >= 97) {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii + 1, jj + 1));
                }
                if (jj-1>=0&&chessComponents[ii + 1][jj - 1].name >= 97) {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii + 1, jj - 1));
                }

            }
        } else if (chessComponents[ii][jj].name == 'p') {
            if (ii == 6) {
                a = 3;
                if (chessComponents[ii - 1][jj].name == '_' && chessComponents[ii - 2][jj].name == '_')
                    ressultt.add(new ChessboardPoint(ii - 2, jj));
            }
            if (ii - 1 >= 0) {
                if (chessComponents[ii - 1][jj].name == '_') {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii - 1, jj));
                }
                if (jj+1<8&&chessComponents[ii - 1][jj + 1].name <= 90) {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii - 1, jj + 1));
                }
                if (jj-1>=0&&chessComponents[ii - 1][jj - 1].name <= 90) {
                    a = 3;
                    ressultt.add(new ChessboardPoint(ii - 1, jj - 1));

                }
            }
        }
        Collections.sort(ressultt, new Comparator<ChessboardPoint>() {

            @Override
            public int compare(ChessboardPoint p1, ChessboardPoint p2) {

                if (p1.getX() != p2.getX()) {
                    a = 3;
                    return p1.getX() - p2.getX();
                } else {
                    a = 3;
                    return p1.getY() - p2.getY();
                }
            }

        });
        return ressultt;
    }
}
