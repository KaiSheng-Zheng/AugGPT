import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x0 = this.getSource().getX();
        int y0 = this.getSource().getY();
        List<ChessboardPoint> result = new ArrayList<>();

        if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (x0 == 6) {
                for (int i = 1; i <= 2; i++) {
                    if (chessboard[x0 - i][y0].getChessColor().equals(ChessColor.NONE)) {
                        result.add(new ChessboardPoint(x0 - i, y0));
                    }
                }
                if (y0 - 1 >= 0 && chessboard[x0 - 1][y0 - 1].getChessColor().equals(ChessColor.BLACK)) {
                    result.add(new ChessboardPoint(x0 - 1, y0 - 1));
                }
                if (y0 + 1 <= 7 && chessboard[x0 - 1][y0 + 1].getChessColor().equals(ChessColor.BLACK)) {
                    result.add(new ChessboardPoint(x0 - 1, y0 + 1));
                }


            } else {
                if (x0 - 1 >= 0 && chessboard[x0 - 1][y0].getChessColor().equals(ChessColor.NONE)) {
                    result.add(new ChessboardPoint(x0 - 1, y0));
                }
                if (x0 - 1 >= 0 && y0 - 1 >= 0 && chessboard[x0 - 1][y0 - 1].getChessColor().equals(ChessColor.BLACK)) {
                    result.add(new ChessboardPoint(x0 - 1, y0 - 1));
                }
                if (x0 - 1 >= 0 && y0 + 1 <= 7 && chessboard[x0 - 1][y0 + 1].getChessColor().equals(ChessColor.BLACK)) {
                    result.add(new ChessboardPoint(x0 - 1, y0 + 1));
                }
            }


        }


        if (this.getChessColor().equals(ChessColor.BLACK)) {
            if (x0 == 1) {
                for (int i = 1; i <= 2; i++) {
                    if (chessboard[x0 + i][y0].getChessColor().equals(ChessColor.NONE)) {
                        result.add(new ChessboardPoint(x0 + i, y0));
                    }
                }
                if (y0 - 1 >= 0 && chessboard[x0 + 1][y0 - 1].getChessColor().equals(ChessColor.WHITE)) {
                    result.add(new ChessboardPoint(x0 + 1, y0 - 1));
                }
                if (y0 + 1 <= 7 && chessboard[x0 + 1][y0 + 1].getChessColor().equals(ChessColor.WHITE)) {
                    result.add(new ChessboardPoint(x0 + 1, y0 + 1));
                }


            } else {
                if (x0 + 1 <= 7 && chessboard[x0 + 1][y0].getChessColor().equals(ChessColor.NONE)) {
                    result.add(new ChessboardPoint(x0 + 1, y0));
                }
                if (x0 + 1 <= 7 && y0 - 1 >= 0 && chessboard[x0 + 1][y0 - 1].getChessColor().equals(ChessColor.WHITE)) {
                    result.add(new ChessboardPoint(x0 + 1, y0 - 1));
                }
                if (x0 + 1 <= 7 && y0 + 1 <= 7 && chessboard[x0 + 1][y0 + 1].getChessColor().equals(ChessColor.WHITE)) {
                    result.add(new ChessboardPoint(x0 + 1, y0 + 1));
                }
            }


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
