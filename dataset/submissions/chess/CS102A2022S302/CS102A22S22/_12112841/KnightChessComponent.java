import java.util.List;
import java.util.ArrayList;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.WHITE) {
            this.name = 'n';
        } else {
            this.name = 'N';
        }
    }

    @Override
   public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        int[][] destination2 = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        for (int i = 0; i < 8; i++) {
            int x = destination2[i][0];
            int y = destination2[i][1];
            ChessboardPoint moveto = source.offset(x, y);
//            ChessComponent newcomponent = chessComponents[moveto.getX()][moveto.getY()];
//            char player = newcomponent.toString().charAt(0);
//            ChessColor newcolor = PlayerColor(player);
            if (moveto != null) {
                if (PlayerColor(chessComponents[moveto.getX()][moveto.getY()].toString().charAt(0)) != chessColor) {
                    canmoveto.add(moveto);
                }
            }
        }
        return canmoveto;
    }
}
