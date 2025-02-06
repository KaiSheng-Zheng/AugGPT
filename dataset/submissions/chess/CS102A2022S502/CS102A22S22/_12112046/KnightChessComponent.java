import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> knight = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if ((x + 2) <= 7) {
            if ((y + 1) <= 7 && getChessColor() != chessboard[x + 2][y + 1].getChessColor()) {
                knight.add(new ChessboardPoint(x + 2, y + 1));
            }
            if ((y - 1) >= 0 && getChessColor() != chessboard[x + 2][y - 1].getChessColor()) {
                knight.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
        if ((x - 2) >= 0) {
            if ((y + 1) <= 7 && getChessColor() != chessboard[x - 2][y + 1].getChessColor()) {
                knight.add(new ChessboardPoint(x - 2, y + 1));
            }
            if ((y - 1) >= 0 && getChessColor() != chessboard[x - 2][y - 1].getChessColor()) {
                knight.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if ((x + 1) <= 7) {
            if ((y + 2) <= 7 && getChessColor() != chessboard[x + 1][y + 2].getChessColor()) {
                knight.add(new ChessboardPoint(x + 1, y + 2));
            }
            if ((y - 2) >= 0 && getChessColor() != chessboard[x + 1][y - 2].getChessColor()) {
                knight.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
        if ((x - 1) >= 0) {
            if ((y + 2) <= 7 && getChessColor() != chessboard[x - 1][y + 2].getChessColor()) {
                knight.add(new ChessboardPoint(x - 1, y + 2));
            }
            if ((y - 2) >= 0 && getChessColor() != chessboard[x - 1][y - 2].getChessColor()) {
                knight.add(new ChessboardPoint(x - 1, y - 2));
            }
//            for (int i = 0; i < knight.size(); i++) {
//                System.out.println(knight.get(i));
//            }
        }
        return knight;
    }

}
