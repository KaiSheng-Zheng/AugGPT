import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'Q';
        }
        if(color == ChessColor.WHITE){
            this.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> queen = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int H = source.getX();
        int V = source.getY();
        int e = 0;
        int r = 0;
        int t = 0;
        int d = 0;
        int f = 0;
        int g = 0;
        int h = 0;
        int k = 0;

        if (chessBoard[source.getX()][source.getY()].name == ('Q')) {

            for (int y = source.getY() + 1; y < 8 ; y++) {
                if ((chessBoard[source.getX()][y].name == '_' | chessBoard[H][V].getChessColor()==ChessColor.WHITE)) {
                    if (chessBoard[H][V].getChessColor()==ChessColor.WHITE) e++;
                    queen.add(new ChessboardPoint(H, y));
                    if(e==1) break;
                }else break;
            }
            for (int y = V -1; y >=0; y--) {
                if ((chessBoard[source.getX()][y].name == '_' | chessBoard[H][V].getChessColor()==ChessColor.WHITE)) {
                    if (chessBoard[H][V].getChessColor()==ChessColor.WHITE) r++;
                    queen.add(new ChessboardPoint(source.getX(), y));
                    if(r==1) break;
                }else break;
            }  //vertical
            for (int x = H + 1; x < 8 ; x++) {
                if (chessBoard[x][source.getY()].name == '_' | chessBoard[x][V].getChessColor()==ChessColor.WHITE) {
                    if (chessBoard[x][V].getChessColor()==ChessColor.WHITE) t++;
                    queen.add(new ChessboardPoint(x, source.getY()));
                    if(t==1) break;
                } else break;
            }
            for (int x = H-1; x >=0; x--) {
                if (chessBoard[x][V].name == '_' | chessBoard[x][V].getChessColor()==ChessColor.WHITE) {
                    if ((int) chessBoard[x][V].name > 95) d++;
                    queen.add(new ChessboardPoint(x, source.getY()));
                    if(d==1) break;
                }else break;
            }  // horizontal
            int y = V;
            for (int x = H + 1; x < 8 ; x++) {
                y--;
                if (y>=0 &&(chessBoard[x][y].name == '_' | chessBoard[x][y].getChessColor()==ChessColor.WHITE)){
                    if (chessBoard[x][y].getChessColor()==ChessColor.WHITE) f++;
                    queen.add(new ChessboardPoint(x, y));
                    if(f==1) break;
                } else {
                    break;
                }
            }  // the fourth quadrant
            int Y = V;
            for (int x = H-1; x >= 0 ; x--) {
                Y++;
                if (Y <= 7 && chessBoard[x][Y].name == '_' |  chessBoard[x][Y].getChessColor()==ChessColor.WHITE) {
                    if (chessBoard[x][Y].getChessColor()==ChessColor.WHITE) g++;
                    queen.add(new ChessboardPoint(x, Y));
                    if(g==1) break;
                }else break;
            }//the second quadrant
            int p = source.getY();
            for (int x = H + 1; x < 8 ; x++) {
                p++;
                if (p <= 7 && chessBoard[x][p].name == '_' |  chessBoard[x][p].getChessColor()==ChessColor.WHITE) {
                    if ((int) chessBoard[x][p].name > 95) h++;
                    queen.add(new ChessboardPoint(x, p));
                    if(h==1)break;
                } else break;
            } // the first quadrant
            int P = V;
            for (int x = H - 1; x >= 0; x--) {
                P--;
                if (P >= 0 && chessBoard[x][P].name == '_' | chessBoard[x][P].getChessColor()==ChessColor.WHITE) {
                    if ( chessBoard[x][P].getChessColor()==ChessColor.WHITE) k++;
                    queen.add(new ChessboardPoint(x, P));
                    if(k==1) break;
                } else break;
                // the third quadrant
            }
        }

        if (chessBoard[source.getX()][source.getY()].name == ('q')) {
            for (int y = V + 1; y < 8 ; y++) {
                if ((chessBoard[H][y].name == '_' | chessBoard[H][y].getChessColor()==ChessColor.BLACK)) {
                    if (chessBoard[H][y].getChessColor()==ChessColor.BLACK) e++;
                    queen.add(new ChessboardPoint(H, y));
                    if(e==1) break;
                } else break;
            }
            for (int y = V-1; y >=0; y--) {
                if ((chessBoard[H][y].name == '_' | chessBoard[H][y].getChessColor()==ChessColor.BLACK)) {
                    if (chessBoard[H][y].getChessColor()==ChessColor.BLACK) r++;
                    queen.add(new ChessboardPoint(H, y));
                    if(r==1) break;
                } else break;
            }  //vertical
            for (int x = H + 1; x < 8 ; x++) {
                if (chessBoard[x][V].name == '_' | chessBoard[x][V].getChessColor()==ChessColor.BLACK) {
                    if (chessBoard[x][V].getChessColor()==ChessColor.BLACK) t++;
                    queen.add(new ChessboardPoint(x, V));
                    if(t==1) break;
                } else break;
            }
            for (int x = H-1; x >=0; x--) {
                if (chessBoard[x][V].name == '_' | chessBoard[x][V].getChessColor()==ChessColor.BLACK) {
                    if (chessBoard[x][V].getChessColor()==ChessColor.BLACK) d++;
                    queen.add(new ChessboardPoint(x, V));
                    if(d==1) break;
                } else break;
            }  // horizontal
             int y = V ;
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                y--;
                if (chessBoard[x][y].name == '_' |chessBoard[x][y].getChessColor()==ChessColor.BLACK) {
                    if (chessBoard[x][y].getChessColor()==ChessColor.BLACK) f++;
                    queen.add(new ChessboardPoint(x, y));
                    if(f==1) break;
                } else break;
            }  // the fourth quadrant
            int l = V;
            for (int x = H-1; x >=0 ; x--) {
                l++;
                if (l <=7 && chessBoard[x][l].name == '_' |chessBoard[x][l].getChessColor()==ChessColor.BLACK) {
                    if (chessBoard[x][l].getChessColor()==ChessColor.BLACK) g++;
                    queen.add(new ChessboardPoint(x, l));
                    if(g==1)  break;
                } else break;
            }  //the second quadrant
            int Y = V;
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                Y++;
                if (Y >= 0 && chessBoard[x][Y].name == '_' | chessBoard[x][Y].getChessColor()==ChessColor.BLACK) {
                    if (chessBoard[x][Y].getChessColor()==ChessColor.BLACK) h++;
                    queen.add(new ChessboardPoint(x, Y));
                    if(h==1) break;
                } else break;
            } // the first quadrant
            int p = V;
            for (int x = H - 1; x >= 0; x--) {
                p--;
                if (p >=0 && (chessBoard[x][p].name == '_' | chessBoard[x][p].getChessColor()==ChessColor.BLACK)) {
                    if (chessBoard[x][p].getChessColor()==ChessColor.BLACK) k++;
                    queen.add(new ChessboardPoint(x, p));
                    if(k==1) break;
                } else break;// the third quadrant
            }
        }

        queen.sort(new a());
        Collections.reverse(queen);
        return queen;
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