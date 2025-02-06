import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;
    private int a = 3;

    public RookChessComponent(char cc, ChessComponent[][] chessComponents) {
        this.name = cc;
        a=3;
        if (cc == 'R') {
            a=3;
            this.color = ChessColor.BLACK;
        } else if (cc == 'r') {
            this.color = ChessColor.WHITE;
            a=3;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        int ii = ConcreteChessGame.xNow1;
        a=3;
        int jj = ConcreteChessGame.yNow2;
        if (chessComponents[ii][jj].name == 'R') {
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0) {
                    a=3;
                    break;
                }
                if (chessComponents[ii - kk][jj].name <= 90) {
                    a=3;
                    break;
                }
                if (chessComponents[ii - kk][jj].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj));
                    a=3;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj - kk < 0) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj - kk].name <= 90) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj - kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii, jj - kk));
                    a=3;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj + kk > 7) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj + kk].name <= 90) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj + kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii, jj + kk));
                    a=3;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj].name <= 90) {
                    a=3;
                    break;
                }
                if (chessComponents[ii + kk][jj].name >= 97) {
                    a=3;
                    ressultt.add(new ChessboardPoint(ii + kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj));
            }

        } else if (chessComponents[ii][jj].name == 'r') {
            for (int kk = 1; kk < 8; kk++) {
                a=3;
                if (ii - kk < 0) {
                    break;
                }
                if (chessComponents[ii - kk][jj].name >= 97) {
                    a=3;
                    break;
                }
                if (chessComponents[ii - kk][jj].name <= 90) {
                    a=3;
                    ressultt.add(new ChessboardPoint(ii - kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj - kk < 0) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj - kk].name >= 97) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii, jj - kk));
                    a=3;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj + kk > 7) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj + kk].name >= 97) {
                    a=3;
                    break;
                }
                if (chessComponents[ii][jj + kk].name <= 90) {
                    a=3;
                    ressultt.add(new ChessboardPoint(ii, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7) {
                    a=3;
                    break;
                }
                if (chessComponents[ii + kk][jj].name >= 97) {
                    a=3;
                    break;
                }
                if (chessComponents[ii + kk][jj].name <= 90) {
                    a=3;
                    ressultt.add(new ChessboardPoint(ii + kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj));
                a=3;
            }
        }


        Collections.sort(ressultt, new Comparator<ChessboardPoint>() {
            int a=3;

            @Override
            public int compare(ChessboardPoint pp1, ChessboardPoint p22) {
a=3;
                if (pp1.getX() != p22.getX()) {
                    a=3;
                    return pp1.getX() - p22.getX();
                } else {
                    a=3;
                    return pp1.getY() - p22.getY();
                }
            }

        });
        return ressultt;
    }
}
