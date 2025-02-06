import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    int move = 0;

    public PawnChessComponent (int move){
        this.move=move;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (getChessColor() == ChessColor.WHITE) {
            int[][] directions = {{-1, -1}, {-1, 1}};
            List<ChessboardPoint> move = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                ChessboardPoint point = getSource();
                int[] a = directions[i];
                ChessboardPoint newp = point.offset(a[0], a[1]);
                if (newp != null && chessboard[newp.getX()][newp.getY()].getChessColor() ==ChessColor.BLACK) {
                    move.add(newp);
                }
            }
            ChessboardPoint point1 = getSource();
            ChessboardPoint newp1 = point1.offset(-1, 0);
            if(newp1==null){
                return move;
            }
            ChessComponent chessComponent = chessboard[newp1.getX()][newp1.getY()];
            if (chessComponent instanceof EmptySlotComponent) {
                move.add(newp1);
                if (this.move == 0) {
                    ChessboardPoint newp2 = newp1.offset(-1, 0);
                    chessComponent = chessboard[newp2.getX()][newp2.getY()];
                    if (chessComponent instanceof EmptySlotComponent) {
                        move.add(newp2);
                    }
                }
            }
            return move;
        }
        else {
            int[][] directions = {{1, -1}, {1, 1}};
            List<ChessboardPoint> move = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                ChessboardPoint point = getSource();
                int[] a = directions[i];
                ChessboardPoint newp = point.offset(a[0], a[1]);
                if (newp != null && chessboard[newp.getX()][newp.getY()].getChessColor() ==ChessColor.WHITE) {
                    move.add(newp);
                }
            }
            ChessboardPoint point1 = getSource();
            ChessboardPoint newp1 = point1.offset(1, 0);
            if(newp1==null){
                return move;
            }
            ChessComponent chessComponent = chessboard[newp1.getX()][newp1.getY()];
            if (chessComponent instanceof EmptySlotComponent) {
                move.add(newp1);
                if (this.move == 0) {
                    ChessboardPoint newp2 = newp1.offset(1, 0);
                    chessComponent = chessboard[newp2.getX()][newp2.getY()];
                    if (chessComponent instanceof EmptySlotComponent) {
                        move.add(newp2);
                    }
                }
            }
            return move;
        }
    }
}
