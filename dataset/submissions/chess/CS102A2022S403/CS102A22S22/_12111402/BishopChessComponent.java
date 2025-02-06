import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0 = this.getSource().getX();
        int y0 = this.getSource().getY();
        List<ChessboardPoint> result = new ArrayList<>();

        for (int i = 1; x0 + i <= 7 && y0 + i <= 7; i++) {//low right
            if (chessboard[x0 + i][y0 + i].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0 + i, y0 + i));
            } else if (!chessboard[x0 + i][y0 + i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0 + i, y0 + i));
                break;
            } else break;
        }
        for (int i = -1; x0 + i >= 0 && y0 + i >= 0; i--) {//upper left
            if (chessboard[x0 + i][y0 + i].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0 + i, y0 + i));
            } else if (!chessboard[x0 + i][y0 + i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0 + i, y0 + i));
                break;
            } else break;
        }
        for (int i = 1; x0 + i <= 7 && y0 - i >= 0; i++) {//low left
            if (chessboard[x0 + i][y0 - i].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0 + i, y0 - i));
            } else if (!chessboard[x0 + i][y0 - i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0 + i, y0 - i));
                break;
            } else break;
        }
        for (int i = 1; x0 - i >= 0 && y0 + i <= 7; i++) {//upper right
            if (chessboard[x0 - i][y0 + i].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0 - i, y0 + i));
            } else if (!chessboard[x0 - i][y0 + i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0 - i, y0 + i));
                break;
            } else break;
        }


        for (int a = 0; a < result.size(); a++) {
            for (int b = a + 1; b < result.size(); b++) {
                if (result.get(a).getX() > result.get(b).getX()) {
                    ChessboardPoint temp = result.get(a);
                    result.set(a, result.get(b));
                    result.set(b, temp);
                } else if (result.get(a).getX() == result.get(b).getX()) {
                    if (result.get(a).getY() > result.get(b).getY()) {
                        ChessboardPoint temp = result.get(a);
                        result.set(a, result.get(b));
                        result.set(b, temp);
                    }
                }
            }
        }
        return result;
    }
}
