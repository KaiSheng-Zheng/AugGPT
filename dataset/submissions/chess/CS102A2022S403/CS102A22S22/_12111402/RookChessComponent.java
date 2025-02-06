import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0 = this.getSource().getX();
        int y0 = this.getSource().getY();
        List<ChessboardPoint> result = new ArrayList<>();

        for (int x = x0 + 1; x <= 7; x++) {//low
            if (chessboard[x][y0].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x, y0));
            } else if (!chessboard[x][y0].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x, y0));
                break;
            } else break;
        }
        for (int x = x0 - 1; x >= 0; x--) {//upper
            if (chessboard[x][y0].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x, y0));
            } else if (!chessboard[x][y0].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x, y0));
                break;
            } else break;
        }

        for (int y = y0 + 1; y <= 7; y++) {//right
            if (chessboard[x0][y].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0, y));
            } else if (!chessboard[x0][y].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0, y));
                break;
            } else break;
        }

        for (int y = y0 - 1; y >= 0; y--) {//left
            if (chessboard[x0][y].getChessColor().equals(ChessColor.NONE)) {
                result.add(new ChessboardPoint(x0, y));
            } else if (!chessboard[x0][y].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(x0, y));
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
