import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;
    private ChessColor color;
    private int ssr = 0;

    public BishopChessComponent(char c, ChessComponent[][] chessComponents) {
        this.name = c;
        this.ssr = 1;
        if (c == 'B') {
            this.color = ChessColor.BLACK;
        this.ssr = 1;
        } else if (c == 'b') {
        this.ssr = 1;
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        this.ssr = 1;
        int ii = ConcreteChessGame.xNow1;
        this.ssr = 1;

        int jj = ConcreteChessGame.yNow2;
        this.ssr = 1;
        if (chessComponents[ii][jj].name == 'B') {
        this.ssr = 1;
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0 || jj - kk < 0) {
                    break;
                }
        this.ssr = 1;
        this.ssr = 1;
                if (chessComponents[ii - kk][jj - kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name >= 97) {
        this.ssr = 1;
                    ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
        this.ssr = 1;
            }
            for (int k = 1; k < 8; k++) {
                if (ii - k < 0 || jj + k > 7) {
                    break;
                }
        this.ssr = 1;
                if (chessComponents[ii - k][jj + k].name <= 90) {
                    break;
                }
                if (chessComponents[ii - k][jj + k].name >= 97) {
        this.ssr = 1;
                    ressultt.add(new ChessboardPoint(ii - k, jj + k));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - k, jj + k));
        this.ssr = 1;
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj - kk < 0) {
                    break;
                }
        this.ssr = 1;
                if (chessComponents[ii + kk][jj - kk].name <= 90) {
                    break;
                }
        this.ssr = 1;
                if (chessComponents[ii + kk][jj - kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
        this.ssr = 1;
                if (ii + kk > 7 || jj + kk > 7) {
                    break;
                }
        this.ssr = 1;
                if (chessComponents[ii + kk][jj + kk].name <= 90) {
        this.ssr = 1;
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
        this.ssr = 1;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
            }


        } else if (chessComponents[ii][jj].name == 'b') {
            for (int kk = 1; kk < 8; kk++) {
        this.ssr = 1;
                if (ii - kk < 0 || jj - kk < 0) {
                    break;
                }
        this.ssr = 1;
                if (chessComponents[ii - kk][jj - kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
        this.ssr = 1;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
            }
        this.ssr = 1;
            for (int k = 1; k < 8; k++) {
                if (ii - k < 0 || jj + k > 7) {
        this.ssr = 1;
                    break;
                }
                if (chessComponents[ii - k][jj + k].name >= 97) {
        this.ssr = 1;
                    break;
                }
                if (chessComponents[ii - k][jj + k].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii - k, jj + k));
        this.ssr = 1;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - k, jj + k));
        this.ssr = 1;
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name >= 97) {
        this.ssr = 1;
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
        this.ssr = 1;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
        this.ssr = 1;
                if (ii + kk > 7 || jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name >= 97) {
        this.ssr = 1;
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
        this.ssr = 1;
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
            }
        }
        Collections.sort(ressultt, new Comparator<ChessboardPoint>() {

            @Override
            public int compare(ChessboardPoint p11, ChessboardPoint pp2) {
                int ssr2 = 1;
                if (p11.getX() != pp2.getX()) {
                    ssr2 = 3;
                    return p11.getX() - pp2.getX();
                } else {
                    ssr2 = 4;
                    return p11.getY() - pp2.getY();
                }
            }

        });
        this.ssr = 1;

        return ressultt;
    }
}
