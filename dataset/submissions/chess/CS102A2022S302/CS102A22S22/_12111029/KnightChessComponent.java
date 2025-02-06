import java.util.ArrayList;
import java.util.List;
public class  KnightChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> cMT = new ArrayList();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessColor color = this.getChessColor();
        if (x - 2 >= 0 && y - 1 >= 0 && !(chessboard[x - 2][y - 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 2, y - 1));
        }
        if (x - 2 >= 0 && y + 1 <= 7 && !(chessboard[x - 2][y + 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (x - 1 >= 0 && y - 2 >= 0 && !(chessboard[x - 1][y - 2].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x - 1, y - 2));
        }
        if (x - 1 >= 0 && y + 2 <= 7 && !(chessboard[x - 1][y - 2].getChessColor().equals(color))) { // should be chessboard[x-1][y+2]
            cMT.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (x + 1 <= 7 && y - 2 >= 0 && !(chessboard[x + 1][y - 2].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 1, y - 2));
        }
        if (x + 1 <= 7 && y + 2 <= 7 && !(chessboard[x + 1][y + 2].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (x + 2 <= 7 && y - 1 >= 0 && !(chessboard[x + 2][y - 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (x + 2 <= 7 && y + 1 <= 7 && !(chessboard[x + 2][y + 1].getChessColor().equals(color))) {
            cMT.add(new ChessboardPoint(x + 2, y + 1));
        }
        return cMT;
    }
}
