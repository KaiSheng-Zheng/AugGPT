import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int i, int j, char identity) {
        super(i, j, identity);
        this.name = 'P';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int a = 0;
        if (this.chessColor() == ChessColor.WHITE) {
            a = -1;
        } else {
            a = 1;
        }
        if (chessboard[this.getSource().getX() + a][this.getSource().getY()].name == '_') {
            canMoveTo.add(this.getSource().offset(a, 0));
            if (chessboard[this.getSource().getX() + a * 2][this.getSource().getY()].name == '_' && this.getSource().getX() == 3.5 - a * 2.5) {
                canMoveTo.add(this.getSource().offset(a * 2, 0));
            }
        }

        if (this.getSource().getY() != 7) {
            if (chessboard[this.getSource().getX() + a][this.getSource().getY() + 1].name != '_' &&
                    chessboard[this.getSource().getX() + a][this.getSource().getY() + 1].chessColor() != this.chessColor()) {
                canMoveTo.add(this.getSource().offset(a, 1));
            }
        }
        if (this.getSource().getY() != 0) {
            if (chessboard[this.getSource().getX() + a][this.getSource().getY() - 1].name != '_' &&
                    chessboard[this.getSource().getX() + a][this.getSource().getY() - 1].chessColor() != this.chessColor()) {
                canMoveTo.add(this.getSource().offset(a, -1));
            }
        }
        while (canMoveTo.contains(null)) {
            canMoveTo.remove(null);
        }
        return canMoveTo;
    }
}
