import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        int x = source.getX(), y = source.getY();

        if (x + 2 >= 0 && x + 2 <= 7 && y + 1 >= 0 && y + 1 <= 7) {
            if (getComponentColor(chessboard[x + 2][y + 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 2, y + 1));
            }
        }
        if (x + 2 >= 0 && x + 2 <= 7 && y - 1 >= 0 && y - 1 <= 7) {
            if (getComponentColor(chessboard[x + 2][y - 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y + 2 >= 0 && y + 2 <= 7) {
            if (getComponentColor(chessboard[x + 1][y + 2].toString().charAt(0) )!= chessColor) {
                moveTo.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y - 2 >= 0 && y - 2 <= 7) {
            if (getComponentColor(chessboard[x + 1][y - 2].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
        if (x - 2 >= 0 && x - 2 <= 7 && y + 1 >= 0 && y + 1 <= 7) {
            if (getComponentColor(chessboard[x - 2][y + 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 2, y + 1));
            }
        }
        if (x - 2 >= 0 && x - 2 <= 7 && y - 1 >= 0 && y - 1 <= 7) {
            if (getComponentColor(chessboard[x - 2][y - 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y + 2 >= 0 && y + 2 <= 7) {
            if (getComponentColor(chessboard[x - 1][y + 2].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y - 2 >= 0 && y - 2 <= 7) {
            if (getComponentColor(chessboard[x - 1][y - 2].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 1, y - 2));
            }
        }
        return moveTo;
    }
}