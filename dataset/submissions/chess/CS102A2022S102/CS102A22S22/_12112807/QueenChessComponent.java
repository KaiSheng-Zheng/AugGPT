import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessColor color;
    private ChessComponent[][] chessComponents;
    public QueenChessComponent(char cc,ChessComponent[][] chessComponents){
        this.name=cc;
        if(cc=='Q'){
            this.color=ChessColor.BLACK;
        }else if(cc=='q'){
            this.color=ChessColor.WHITE;
        }
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        int ii = ConcreteChessGame.xNow1;
        int jj = ConcreteChessGame.yNow2;
        if (chessComponents[ii][jj].name == 'Q') {
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0) {
                    break;
                }
                if (chessComponents[ii - kk][jj].name <= 90) {
                    break;
                }
                if (chessComponents[ii - kk][jj].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii][jj - kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii][jj - kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii][jj + kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii][jj + kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj].name <= 90) {
                    break;
                }
                if (chessComponents[ii + kk][jj].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0 || jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0 || jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii - kk][jj + kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii - kk][jj + kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name <= 90) {
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name >= 97) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
            }

        }else if(chessComponents[ii][jj].name == 'q'){
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0) {
                    break;
                }
                if (chessComponents[ii - kk][jj].name >= 97) {
                    break;
                }
                if (chessComponents[ii - kk][jj].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii][jj - kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii][jj + kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii][jj + kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj].name >= 97) {
                    break;
                }
                if (chessComponents[ii + kk][jj].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0 || jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii - kk][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii - kk < 0 || jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii - kk][jj + kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii - kk][jj + kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii - kk, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii - kk, jj + kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj - kk < 0) {
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii + kk][jj - kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj - kk));
            }
            for (int kk = 1; kk < 8; kk++) {
                if (ii + kk > 7 || jj + kk > 7) {
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name >= 97) {
                    break;
                }
                if (chessComponents[ii + kk][jj + kk].name <= 90) {
                    ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
                    break;
                }
                ressultt.add(new ChessboardPoint(ii + kk, jj + kk));
            }

        }
        Collections.sort(ressultt, new Comparator<ChessboardPoint>() {

            @Override
            public int compare(ChessboardPoint pp1, ChessboardPoint p22) {

                if (pp1.getX() != p22.getX()) {
                    return pp1.getX() - p22.getX();
                } else {
                    return pp1.getY() - p22.getY();
                }
            }

        });
        return ressultt;
    }
}
