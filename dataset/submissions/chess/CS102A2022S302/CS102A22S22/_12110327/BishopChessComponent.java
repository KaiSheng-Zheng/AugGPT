import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'B';
        }
        if(color == ChessColor.WHITE){
            this.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> bishop = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int H = source.getX();
        int V = source.getY();
            int f = 0;
            int g = 0;
            int h = 0;
            int k = 0;
            int y = V ;
        if (chessBoard[H][V].getChessColor() == ChessColor.BLACK) {
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                y++;
                if (y <= 7 && chessBoard[x][y].getChessColor() == ChessColor.NONE | chessBoard[x][y].getChessColor() == ChessColor.WHITE) {
                    if (chessBoard[x][y].getChessColor() == ChessColor.WHITE) f++;
                    bishop.add(new ChessboardPoint(x, y));
                    if (f == 1) break;
                } else {
                    break;
                }
            }
                  // the first quadrant
                int p = V;
                for (int x = H - 1; x >= 0; x--) {
                    p++;
                    if (p <= 7 && chessBoard[x][p].name == '_' | (int) chessBoard[x][p].name > 94) {
                        if ((int) chessBoard[x][p].name > 95) g++;
                        bishop.add(new ChessboardPoint(x, p));
                        if (g == 1) break;
                    } else {
                        break;
                    }
                }  //the second quadrant
                int Y = V;
                for (int x = H + 1; x < 8 & x >= 0; x++) {
                    Y--;
                    if (Y >= 0 && chessBoard[x][Y].name == '_' | (int) chessBoard[x][Y].name > 94) {
                        if ((int) chessBoard[x][Y].name > 95) h++;
                        bishop.add(new ChessboardPoint(x, Y));
                        if (h == 1) break;
                    } else break;
                } // the fourth quadrant
                int P = V;
                for (int x = H - 1; x >= 0; x--) {
                    P--;
                    if (P >= 0 && chessBoard[x][P].name == '_' | (int) chessBoard[x][P].name > 94) {
                        if ((int) chessBoard[x][P].name > 95) k++;
                        bishop.add(new ChessboardPoint(x, P));
                        if (k == 1) break;
                    } else break;
                }// the third quadrant
            }

        if(chessBoard[H][V].getChessColor() == ChessColor.WHITE){
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                y++;
                if (y <= 7 && chessBoard[x][y].name == '_' | (int) chessBoard[x][y].name < 94) {
                    if ((int) chessBoard[x][y].name < 95) f++;
                    bishop.add(new ChessboardPoint(x, y));
                    if(f==1) break;
                } else {
                    break;
                }
            }  // the first quadrant
            int p = V;
            for (int x = H - 1; x >= 0; x--) {
                p++;
                if (p<=7 &&(chessBoard[x][p].name == '_' | (int) chessBoard[x][p].name < 94)) {
                    if ((int) chessBoard[x][p].name < 95) g++;
                    bishop.add(new ChessboardPoint(x, p));
                    if(g == 1) break;
                } else break;
            }
            //the second quadrant
            int Y = V;
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                Y--;
                if (Y >= 0 && chessBoard[x][Y].name == '_' | (int) chessBoard[x][Y].name < 94) {
                    if ((int) chessBoard[x][Y].name < 95) h++;
                    bishop.add(new ChessboardPoint(x, Y));
                    if(h==1)  break;
                } else break;
            } // the fourth quadrant
            int P = V;
            for (int x = H - 1; x >= 0; x--) {
                P--;
                if (P >=0 && chessBoard[x][P].name == '_' | (int) chessBoard[x][P].name < 94) {
                    if ((int) chessBoard[x][P].name < 95) k++;
                    bishop.add(new ChessboardPoint(x, P));
                    if(k==1)  break;
                } else break;
            } // the third quadrant

        }

        bishop.sort(new a());
        Collections.reverse(bishop);
        return bishop;
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