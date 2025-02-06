import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class RookChessComponent  extends  ChessComponent{
    public RookChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'R';
        }
        if(color == ChessColor.WHITE){
            this.name = 'r';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        List<ChessboardPoint> rook = new ArrayList<>();
        int H = source.getX();
        int V = source.getY();
        int e = 0;
        int r = 0;
        int t = 0;
        int d = 0;

        if (chessBoard[source.getX()][source.getY()].name == ('R')) {

            for (int y = V + 1; y < 8 & y >= 0; y++) {
                if ((chessBoard[H][y].name == '_' | (int) chessBoard[H][y].name > 95)) {
                    if ((int) chessBoard[H][y].name > 95) e++;
                    rook.add(new ChessboardPoint(H, y));
                    if(e==1) break;
                } else break;
            }
            for (int y = V-1; y >=0; y--) {
                if ((chessBoard[H][y].name == '_' | (int) chessBoard[H][y].name > 95)) {
                    if ((int) chessBoard[H][y].name > 95) r++;
                    rook.add(new ChessboardPoint(H, y));
                    if(r==1) break;
                } else break;
            }  //vertical
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                if (chessBoard[x][V].name == '_' | (int) chessBoard[x][V].name > 94) {
                    if ((int) chessBoard[x][V].name > 95) t++;
                    rook.add(new ChessboardPoint(x, V));
                    if(t==1) break;
                } else break;
            }
            for (int x = H-1; x >= 0 ; x--) {
                if (chessBoard[x][V].name == '_' | (int) chessBoard[x][V].name > 94) {
                    if ((int) chessBoard[x][V].name > 95) d++;
                    rook.add(new ChessboardPoint(x, V));
                    if(d==1) break;
                } else break;
            }  // horizontal
        }

        if (chessBoard[source.getX()][source.getY()].name == ('r')) {
            for (int y = V + 1; y < 8 & y >= 0; y++) {
                if ((chessBoard[H][y].name == '_' | (int) chessBoard[H][y].name < 95)) {
                    if ((int) chessBoard[H][y].name < 95) e++;
                    rook.add(new ChessboardPoint(H, y));
                    if(e == 1) break;
                } else break;
            }
            for (int y = V-1; y >=0; y--) {
                if ((chessBoard[H][y].name == '_' | (int) chessBoard[H][y].name < 95)) {
                    if ((int) chessBoard[H][y].name < 95) r++;
                    rook.add(new ChessboardPoint(H, y));
                    if(r == 1) break;
                } else break;
            }  //vertical
            for (int x = H + 1; x < 8 & x >= 0; x++) {
                if (chessBoard[x][V].name == '_' | (int) chessBoard[x][V].name < 94) {
                    if ((int) chessBoard[x][V].name < 95) t++;
                    rook.add(new ChessboardPoint(x, V));
                    if(t == 1) break;
                } else break;
            }
            for (int x = H-1; x >= 0; x--) {
                if (chessBoard[x][V].name == '_' | (int) chessBoard[x][V].name < 94) {
                    if ((int) chessBoard[x][V].name < 95) d++;
                    rook.add(new ChessboardPoint(x, V));
                    if(d == 1) break;
                } else break;
            }  // horizontal
        }
        rook.sort(new a());
        Collections.reverse(rook);
        return rook;
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
