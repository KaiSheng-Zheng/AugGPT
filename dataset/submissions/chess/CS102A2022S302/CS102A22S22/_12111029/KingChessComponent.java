import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> cMT = new ArrayList();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessColor color = this.getChessColor();
        if (x >= 0 && x <= 7 && y - 1 >= 0 && y - 1 <= 7 && !(chessboard[x][y - 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x, y - 1));
        }
        if (x >= 0 && x <= 7 && y + 1 >= 0 && y + 1 <= 7 && !(chessboard[x][y + 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x, y + 1));
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y - 1 >= 0 && y - 1 <= 7 && !(chessboard[x - 1][y - 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 1, y - 1));
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y >= 0 && y <= 7 && !(chessboard[x - 1][y].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 1, y));
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y + 1 >= 0 && y + 1 <= 7 && !(chessboard[x - 1][y + 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y - 1 >= 0 && y - 1 <= 7 && !(chessboard[x + 1][y - 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y >= 0 && y <= 7 && !(chessboard[x + 1][y].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 1, y));
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y + 1 >= 0 && y + 1 <= 7 && !(chessboard[x + 1][y + 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 1, y + 1));
        }
        return cMT;
    }
}
