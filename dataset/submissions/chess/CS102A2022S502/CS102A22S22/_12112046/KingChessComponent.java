import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent() {

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> king = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x != 7 && chessboard[x + 1][y].getChessColor() != getChessColor()) {
            king.add(new ChessboardPoint(x + 1, y));
            if (y != 7 && chessboard[x + 1][y + 1].getChessColor() != getChessColor()) {
                king.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (y != 0 && chessboard[x + 1][y - 1].getChessColor() != getChessColor()) {
                king.add(new ChessboardPoint(x + 1, y - 1));
            }
        }
        if (x != 0 && chessboard[x - 1][y].getChessColor() != getChessColor()) {
            king.add(new ChessboardPoint(x - 1, y));
            if (y != 0 && chessboard[x - 1][y - 1].getChessColor() != getChessColor()) {
                king.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (y != 7 && chessboard[x - 1][y + 1].getChessColor() != getChessColor()) {
                king.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        if (y != 7 && chessboard[x][y + 1].getChessColor() != getChessColor()) {
            king.add(new ChessboardPoint(x, y + 1));
        }
        if (y != 0 && chessboard[x][y - 1].getChessColor() != getChessColor()) {
            king.add(new ChessboardPoint(x, y - 1));
        }
        return king;
    }


}
