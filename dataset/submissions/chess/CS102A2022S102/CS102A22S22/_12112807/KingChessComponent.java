import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;
    private int a = 4;
    public KingChessComponent(char cc, ChessComponent[][] chessComponents) {
        this.name = cc;
        if (cc == 'K') {
            a = 4;
            this.color = ChessColor.BLACK;
        } else if (cc == 'k') {
            a = 4;
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        a = 4;
        int ii = ConcreteChessGame.xNow1;
        int jj = ConcreteChessGame.yNow2;
        a = 4;
        if (chessComponents[ii][jj].name == 'K') {
            if (ii - 1 >= 0 && jj - 1 >= 0 && chessComponents[ii - 1][jj - 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 1, jj - 1));a = 4;
            }
            if (ii - 1 >= 0 && chessComponents[ii - 1][jj].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 1, jj));a = 4;
            }
            if (ii - 1 >= 0 && jj + 1 < 8 && chessComponents[ii - 1][jj + 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 1, jj + 1));
            }
            if (jj - 1 >= 0 && chessComponents[ii][jj - 1].name > 90) {a = 4;
                ressultt.add(new ChessboardPoint(ii, jj - 1));
            }
            if (jj + 1 < 8 && chessComponents[ii][jj + 1].name > 90) {a = 4;
                ressultt.add(new ChessboardPoint(ii, jj + 1));
            }
            if (ii + 1 < 8 && jj - 1 >= 0 && chessComponents[ii + 1][jj - 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 1, jj - 1));a = 4;
            }
            if (ii + 1 < 8 && chessComponents[ii + 1][jj].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 1, jj));a = 4;
            }
            if (ii + 1 < 8 && jj + 1 < 8 && chessComponents[ii + 1][jj + 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 1, jj + 1));a = 4;
            }

        } else if (chessComponents[ii][jj].name == 'k') {
            if (ii - 1 >= 0 && jj - 1 >= 0 && chessComponents[ii - 1][jj - 1].name < 97) {
                ressultt.add(new ChessboardPoint(ii - 1, jj - 1));a = 4;
            }
            if (ii - 1 >= 0 && chessComponents[ii - 1][jj].name < 97) {
                ressultt.add(new ChessboardPoint(ii - 1, jj));
            }
            if (ii - 1 >= 0 && jj + 1 < 8 && chessComponents[ii - 1][jj + 1].name <97) {
                ressultt.add(new ChessboardPoint(ii - 1, jj + 1));a = 4;
            }
            if (jj - 1 >= 0 && chessComponents[ii][jj - 1].name < 97) {
                ressultt.add(new ChessboardPoint(ii, jj - 1));
            }
            if (jj + 1 < 8 && chessComponents[ii][jj + 1].name < 97) {
                ressultt.add(new ChessboardPoint(ii, jj + 1));a = 4;
            }
            if (ii + 1 < 8 && jj - 1 >= 0 && chessComponents[ii + 1][jj - 1].name < 97) {
                ressultt.add(new ChessboardPoint(ii + 1, jj - 1));
            }
            if (ii + 1 < 8 && chessComponents[ii + 1][jj].name <= 97) {
                ressultt.add(new ChessboardPoint(ii + 1, jj));a = 4;
            }
            if (ii + 1 < 8 && jj + 1 < 8 && chessComponents[ii + 1][jj + 1].name < 97) {
                ressultt.add(new ChessboardPoint(ii + 1, jj + 1));
            }a = 4;
        }
        return ressultt;
    }
}
