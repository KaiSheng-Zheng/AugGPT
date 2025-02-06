
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getChessColor() == ChessColor.WHITE) {
            if (y - 1 >= 0 && x - 1 >= 0 && this.getChessComponents()[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                move.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (y + 1 < 8 && x - 1 >= 0 && this.getChessComponents()[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                move.add(new ChessboardPoint(x - 1, y + 1));
            }
            if (x - 1 >= 0 && this.getChessComponents()[x - 1][y].getName() == 95) {
                move.add(new ChessboardPoint(x - 1, y));
                if (x == 6 && this.getChessComponents()[x - 2][y].getName() == 95)
                    move.add(new ChessboardPoint(x - 2, y));
            }
        }
        if (this.getChessColor() == ChessColor.BLACK) {
            if (y - 1 >= 0 && x + 1 < 8 && this.getChessComponents()[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                move.add(new ChessboardPoint(x + 1, y - 1));
            }
            if (y + 1 < 8 && x + 1 < 8 && this.getChessComponents()[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                move.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (x + 1 < 8 && this.getChessComponents()[x + 1][y].getName() == 95) {
                move.add(new ChessboardPoint(x + 1, y));
                if (x == 1 && this.getChessComponents()[x + 2][y].getName() == 95)
                    move.add(new ChessboardPoint(x + 2, y));
            }
        }
        return move;
    }
}
