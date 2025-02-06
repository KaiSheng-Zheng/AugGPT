import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'K';
        }
        if(color == ChessColor.WHITE){
            this.name = 'k';
        }
    }

    public KingChessComponent() {
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> king = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int H = source.getX();
        int V = source.getY();
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if((H + x) >= 0 && (H + x) <= 7 && (V + y) >= 0 && (V + y) <= 7
                                &&chessBoard[H][V].getChessColor() == ChessColor.WHITE) {
                            if ((chessBoard[H + x][V + y].name == '_'
                                    | chessBoard[H + x][V + y].getChessColor() == ChessColor.BLACK)){
                                king.add(new ChessboardPoint(H + x, V + y));
                            }
                        }else
                        if((H + x) >= 0 && (H + x) <= 7 && (V + y) >= 0 && (V + y) <= 7
                                &&chessBoard[H][V].getChessColor() == ChessColor.BLACK) {
                            if(chessBoard[H + x][V + y].getChessColor() != ChessColor.BLACK) {
                                king.add(new ChessboardPoint(H + x, V + y));
                            }
                        }else break;
                    }
                }
                king.sort(new a());
        Collections.reverse(king);
        return king;
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
