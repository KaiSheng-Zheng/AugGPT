import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'N';
        }
        if(color == ChessColor.WHITE){
            this.name = 'n';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> knight = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int H = source.getX();
        int V = source.getY();
        if (chessBoard[source.getX()][source.getY()].name == ('N')) {
            if ((H + 1 <= 7 && V + 2 <= 7 && (chessBoard[H + 1][V + 2].name == '_' | (int) chessBoard[H + 1][V + 2].name > 95))) {
                knight.add(new ChessboardPoint(H + 1, V + 2));
            }
            if ((V + 1 <= 7 && H + 2 <= 7 && (chessBoard[H + 2][V + 1].name == '_' | (int) chessBoard[H + 2][V + 1].name > 95))) {
                knight.add(new ChessboardPoint(H + 2, V + 1));
            }
            if ((H + 1 <= 7 && V - 2 >= 0 && (chessBoard[H + 1][V - 2].name == '_' | (int) chessBoard[H + 1][V - 2].name > 95))) {
                knight.add(new ChessboardPoint(H + 1, V - 2));
            }
            if ((V - 1 >= 0 && H + 2 <= 7 && (chessBoard[H + 2][V - 1].name == '_' | (int) chessBoard[H + 2][V - 1].name > 95))) {
                knight.add(new ChessboardPoint(H + 2, V - 1));
            }
            if ((H - 1 >= 0 && V + 2 <= 7 && (chessBoard[H - 1][V + 2].name == '_' | (int) chessBoard[H - 1][V + 2].name > 95))) {
                knight.add(new ChessboardPoint(H - 1, V + 2));
            }
            if ((V + 1 <= 7 && H - 2 >= 0 && (chessBoard[H - 2][V + 1].name == '_' | (int) chessBoard[H - 2][V + 1].name > 95))) {
                knight.add(new ChessboardPoint(H - 2, V + 1));
            }
            if ((H - 1 >= 0 && V - 2 >= 0 && (chessBoard[H - 1][V - 2].name == '_' | (int) chessBoard[H - 1][V - 2].name > 95))) {
                knight.add(new ChessboardPoint(H - 1, V - 2));
            }
            if ((V - 1 >= 0 && H - 2 >= 0 && (chessBoard[H - 2][V - 1].name == '_' | (int) chessBoard[H - 2][V - 1].name > 95))) {
                knight.add(new ChessboardPoint(H - 2, V - 1));
            }

        }

        if (chessBoard[source.getX()][source.getY()].name == ('n')) {
            if ((H + 1 <= 7 && V + 2 <= 7 && (chessBoard[H + 1][V + 2].name == '_' | (int) chessBoard[H + 1][V + 2].name < 95))) {
                knight.add(new ChessboardPoint(H + 1, V + 2));
            }
            if ((V + 1 <= 7 && H + 2 <= 7 && (chessBoard[H + 2][V + 1].name == '_' | (int) chessBoard[H + 2][V + 1].name < 95))) {
                knight.add(new ChessboardPoint(H + 2, V + 1));
            }
            if ((H + 1 <= 7 && V - 2 >= 0 && (chessBoard[H + 1][V - 2].name == '_' | (int) chessBoard[H + 1][V - 2].name < 95))) {
                knight.add(new ChessboardPoint(H + 1, V - 2));
            }
            if ((V - 1 >= 0 && H + 2 <= 7 && (chessBoard[H + 2][V - 1].name == '_' | (int) chessBoard[H + 2][V - 1].name < 95))) {
                knight.add(new ChessboardPoint(H + 2, V - 1));
            }
            if ((H - 1 >= 0 && V + 2 <= 7 && (chessBoard[H - 1][V + 2].name == '_' | (int) chessBoard[H - 1][V + 2].name < 95))) {
                knight.add(new ChessboardPoint(H - 1, V + 2));
            }
            if ((V + 1 <= 7 && H - 2 >= 0 && (chessBoard[H - 2][V + 1].name == '_' | (int) chessBoard[H - 2][V + 1].name < 95))) {
                knight.add(new ChessboardPoint(H - 2, V + 1));
            }
            if ((H - 1 >= 0 && V - 2 >= 0 && (chessBoard[H - 1][V - 2].name == '_' | (int) chessBoard[H - 1][V - 2].name < 95))) {
                knight.add(new ChessboardPoint(H - 1, V - 2));
            }
            if ((V - 1 >= 0 && H - 2 >= 0 && (chessBoard[H - 2][V - 1].name == '_' | (int) chessBoard[H - 2][V - 1].name < 95))) {
                knight.add(new ChessboardPoint(H - 2, V - 1));
            }
        }
        knight.sort(new a());
        Collections.reverse(knight);
        return knight;
    }

    static class a implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint ch1, ChessboardPoint ch2) {
            if (ch2.getX() != ch1.getX()) {
                return ch2.getX() - ch1.getX();
            } else return ch2.getY() - ch1.getY();
        }
    }
}