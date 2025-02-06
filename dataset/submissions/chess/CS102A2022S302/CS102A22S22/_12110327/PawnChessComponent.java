import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public  class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint point, ChessColor color) {
        super(point,color);
        if(color == ChessColor.BLACK){
            this.name = 'P';
        }
        if(color == ChessColor.WHITE){
            this.name = 'p';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pawn = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int H = source.getX();
        int V = source.getY();

        if (chessBoard[source.getX()][source.getY()].name == ('P')) {
            if ((H + 1 <= 7 && chessBoard[H+1][V ].name == '_')) {
                pawn.add(new ChessboardPoint(H+1, V ));
                if (H==1&&( chessBoard[H+2][V ].name == '_')) pawn.add(new ChessboardPoint(H+2, V ));
            }
            if ((H + 1 <=7 && V + 1 <=7 && chessBoard[H+1][V+1].getChessColor() == ChessColor.WHITE)){
                pawn.add(new ChessboardPoint(H + 1, V + 1));
            }
            if ((H + 1 <= 7 && V - 1 >=0 && chessBoard[H+1][V-1].getChessColor() == ChessColor.WHITE))
                pawn.add(new ChessboardPoint(H + 1, V - 1));
        }

        if (chessBoard[source.getX()][source.getY()].name == ('p')) {
            if ((H - 1 >= 0 && chessBoard[H-1][V].name == '_')) {
                pawn.add(new ChessboardPoint(H, V - 1)); // should be H-1, not V-1
                if (H==6&&( chessBoard[H][V ].name == '_')) pawn.add(new ChessboardPoint(H - 2, V));
            }
            if ((H - 1 >= 0 && V - 1 >= 0 && chessBoard[H-1][V-1].getChessColor() == ChessColor.BLACK))
                pawn.add(new ChessboardPoint(H - 1, V - 1));
            if ((H - 1 >= 0 && V + 1 <=7 && chessBoard[H-1][V+1].getChessColor() == ChessColor.BLACK))
                pawn.add(new ChessboardPoint(H - 1, V + 1));
        }

        pawn.sort(new a());
        Collections.reverse(pawn);
        return pawn;
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
