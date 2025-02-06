import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> knight = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        if (row+1 < 8 && col+2 < 8) {
            if (getChessComponents()[row + 1][col + 2].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row + 1, col + 2));
            }
        }
        if (row+2 < 8 && col + 1 < 8) {
            if (getChessComponents()[row + 2][col + 1].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row + 2, col + 1));
            }
        }
        if (row-1 > -1 && col-2 > -1) {
            if (getChessComponents()[row - 1][col - 2].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row - 1, col - 2));
            }
        }
        if (row-2 > -1 && col - 1 > -1) {
            if (getChessComponents()[row - 2][col - 1].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row - 2, col - 1));
            }
        }
        if (row+1 < 8 && col-2 > -1) {
            if (getChessComponents()[row + 1][col - 2].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row + 1, col - 2));
            }
        }
        if (row+2 < 8 && col - 1 > -1) {
            if (getChessComponents()[row + 2][col - 1].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row + 2, col - 1));
            }
        }
        if (row-1 > -1 && col+2 < 8) {
            if (getChessComponents()[row - 1][col + 2].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row - 1, col + 2));
            }
        }
        if (row-2 > -1 && col + 1 < 8) {
            if (getChessComponents()[row - 2][col + 1].getChessColor() != getChessColor()) {
                knight.add(new ChessboardPoint(row - 2, col + 1));
            }
        }

        return knight;
    }
}
