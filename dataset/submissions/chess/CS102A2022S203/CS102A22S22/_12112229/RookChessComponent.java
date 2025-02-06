import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'r';
        } else {
            name = 'R';
        }
        super.setSource(new ChessboardPoint(x, y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Chessboard.chessboard[i][j].getChessColor() != super.getChessColor()){
                    boolean can=true;
                    if (super.getSource().getX() == i) {
                        int row = super.getSource().getX();
                        for (int col = Math.min(super.getSource().getY(), j) + 1;
                             col < Math.max(super.getSource().getY(), j); col++) {
                            if (!(Chessboard.chessboard[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                    } else if (super.getSource().getY() == j) {
                        int col = super.getSource().getY();
                        for (int row = Math.min(super.getSource().getX(), i) + 1;
                             row < Math.max(super.getSource().getX(), i); row++) {
                            if (!(Chessboard.chessboard[row][col] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                    } else { // Not on the same row or the same column.
                        can= false;
                    }
                    if (can){
                        list.add(Chessboard.chessboard[i][j].getSource());
                    }
                }
            }
        }
        return list;
    }
}
