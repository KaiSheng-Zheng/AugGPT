import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(char cc, ChessComponent[][] chessComponents) {
        this.name = cc;
        if (cc == 'N') {
            this.color = ChessColor.BLACK;
        } else if (cc == 'n') {
            this.color = ChessColor.WHITE;
        }
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ressultt = new ArrayList<>();
        int ii = ConcreteChessGame.xNow1;
        int jj = ConcreteChessGame.yNow2;
        if (chessComponents[ii][jj].name == 'N') {
            if (ii - 2 >= 0 && jj - 1 >= 0 && chessComponents[ii - 2][jj - 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 2, jj - 1));
            }
            if (ii - 2 >= 0 && jj + 1 < 8 && chessComponents[ii - 2][jj + 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 2, jj + 1));
            }
            if (ii - 1 >= 0 && jj - 2 >= 0 && chessComponents[ii - 1][jj - 2].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 1, jj - 2));
            }
            if (ii - 1 >= 0 && jj + 2 < 8 && chessComponents[ii - 1][jj + 2].name > 90) {
                ressultt.add(new ChessboardPoint(ii - 1, jj + 2));
            }
            if (ii + 1 < 8 && jj - 2 >= 0 && chessComponents[ii + 1][jj - 2].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 1, jj - 2));
            }
            if (ii + 1 < 8 && jj + 2 < 8 && chessComponents[ii + 1][jj + 2].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 1, jj + 2));
            }
            if (ii + 2 < 8 && jj - 1 > 0 && chessComponents[ii + 2][jj - 1].name > 90) { // should be jj-1>=0
                ressultt.add(new ChessboardPoint(ii + 2, jj - 1));
            }
            if (ii + 2 < 8 && jj + 1 < 8 && chessComponents[ii + 2][jj + 1].name > 90) {
                ressultt.add(new ChessboardPoint(ii + 2, jj + 1));
            }

        } else if (chessComponents[ii][jj].name == 'n') {
            if (ii - 2 >= 0 && jj - 1 >= 0 && (chessComponents[ii - 2][jj - 1].name < 97 || chessComponents[ii - 2][jj - 1].name > 122)) {
                ressultt.add(new ChessboardPoint(ii - 2, jj - 1));
            }
            if (ii - 2 >= 0 && jj + 1 < 8 && (chessComponents[ii - 2][jj + 1].name < 97 || chessComponents[ii - 2][jj + 1].name > 122)) {
                ressultt.add(new ChessboardPoint(ii - 2, jj + 1));
            }
            if (ii - 1 >= 0 && jj - 2 >= 0 && (chessComponents[ii - 1][jj - 2].name < 97 || chessComponents[ii - 1][jj - 2].name > 122)) {
                ressultt.add(new ChessboardPoint(ii - 1, jj - 2));
            }
            if (ii - 1 >= 0 && jj + 2 < 8 && (chessComponents[ii - 1][jj + 2].name < 97 || chessComponents[ii - 1][jj + 2].name > 122)) {
                ressultt.add(new ChessboardPoint(ii - 1, jj + 2));
            }
            if (ii + 1 < 8 && jj - 2 >= 0 && (chessComponents[ii + 1][jj - 2].name < 97 || chessComponents[ii + 1][jj - 2].name > 122)) {
                ressultt.add(new ChessboardPoint(ii + 1, jj - 2));
            }
            if (ii + 1 < 8 && jj + 2 < 8 && (chessComponents[ii + 1][jj + 2].name < 97 || chessComponents[ii + 1][jj + 2].name > 122)) {
                ressultt.add(new ChessboardPoint(ii + 1, jj + 2));
            }
            if (ii + 2 < 8 && jj - 1 > 0 && (chessComponents[ii + 2][jj - 1].name < 97 || chessComponents[ii + 2][jj - 1].name > 122)) {
                ressultt.add(new ChessboardPoint(ii + 2, jj - 1));
            }
            if (ii + 2 < 8 && jj + 1 < 8 && (chessComponents[ii + 2][jj + 1].name < 97 || chessComponents[ii + 2][jj + 1].name > 122)) {
                ressultt.add(new ChessboardPoint(ii + 2, jj + 1));
            }
        }
        return ressultt;
    }
}
