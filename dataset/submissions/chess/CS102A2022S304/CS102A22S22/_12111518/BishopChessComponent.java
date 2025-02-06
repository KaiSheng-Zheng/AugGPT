import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'B';
        } else {
            name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int y = super.getSource().getY();
        int x = super.getSource().getX();
            for (int i = 1; i <= x; i++) {
                if (y - i >= 0 && chessboard[x - i][y - i].toString().equals("_")) {
                    canMove.add(new ChessboardPoint(x - i, y - i));
                } else if (y - i >= 0 && chessboard[x - i][y - i].getChessColor()!=this.getChessColor()){
                    canMove.add(new ChessboardPoint(x - i, y - i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = 1; i < 8 - x; i++) {
                if (y + i <= 7 && chessboard[x + i][y + i].toString().equals("_")) {
                    canMove.add(new ChessboardPoint(x + i, y + i));
                } else if (y + i <= 7 && chessboard[x + i][y + i].getChessColor()!=this.getChessColor()){
                    canMove.add(new ChessboardPoint(x + i, y + i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = 1; i <= x; i++) {
                if (y + i <= 7 && chessboard[x - i][y + i].toString().equals("_")) {
                    canMove.add(new ChessboardPoint(x - i, y + i));
                } else if (y + i <= 7 && chessboard[x - i][y + i].getChessColor()!=this.getChessColor()){
                    canMove.add(new ChessboardPoint(x - i, y + i));
                    break;
                }else {
                    break;
                }
            }
            for (int i = 1; i < 8 - x; i++) {
                if (y - i >= 0 && chessboard[x + i][y - i].toString().equals("_")) {
                    canMove.add(new ChessboardPoint(x + i, y - i));
                } else if (y - i >= 0 && chessboard[x + i][y - i].getChessColor()!=this.getChessColor()){
                    canMove.add(new ChessboardPoint(x + i, y - i));
                    break;
                }else {
                    break;
                }
            }
        Collections.sort(canMove);
        return canMove;
    }
}
