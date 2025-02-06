import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'R';
        } else {
            name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int y = super.getSource().getY();
        int x = super.getSource().getX();
        for (int i = 1; i <= x; i++) {
            if (chessboard[x - i][y].toString().equals("_")) {
                canMove.add(super.getSource().offset(-i,0));
            } else if (chessboard[x - i][y].getChessColor() != this.getChessColor()) {
                canMove.add(super.getSource().offset(-i,0));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= y; i++) {
            if (chessboard[x][y - i].toString().equals("_")) {
                canMove.add(super.getSource().offset(0,-i));
            } else if (chessboard[x][y - i].getChessColor() != this.getChessColor()) {
                canMove.add(super.getSource().offset(0,-i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7 - y; i++) {
            if (chessboard[x][y + i].toString().equals("_")) {
                canMove.add(super.getSource().offset(0,i));
            } else if (chessboard[x][y + i].getChessColor() != this.getChessColor()) {
                canMove.add(super.getSource().offset(0,i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7 - x; i++) {
            if (chessboard[x + i][y].toString().equals("_")) {
                canMove.add(super.getSource().offset(i,0));
            } else if (chessboard[x + i][y].getChessColor() != this.getChessColor()) {
                canMove.add(super.getSource().offset(i,0));
                break;
            } else {
                break;
            }
        }
        Collections.sort(canMove);
        return canMove;
    }
}
