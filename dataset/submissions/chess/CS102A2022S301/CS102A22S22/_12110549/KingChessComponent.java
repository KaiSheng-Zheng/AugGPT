import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();

        int x = source.getX(), y = source.getY();
        if (x >= 0 && x <= 7 && y - 1 >= 0 && y - 1 <= 7) {
            if (getComponentColor(chessboard[x][y - 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x, y - 1));
            }
        }
        if (x >= 0 && x <= 7 && y + 1 >= 0 && y + 1 <= 7) {
            if ( getComponentColor(chessboard[x][y + 1].toString().charAt(0)) != chessboard[x][y].getChessColor()) {
                moveTo.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (x-1 >= 0 && x-1 <= 7 && y  >= 0 && y  <= 7) {
            if ( getComponentColor(chessboard[x - 1][y].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 1, y));
            }
        }
        if (x+1 >= 0 && x+1 <= 7 && y  >= 0 && y <= 7) {
            if ( getComponentColor(chessboard[x + 1][y].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 1, y));
            }
        }
        if (x+1 >= 0 && x+1 <= 7 && y + 1 >= 0 && y + 1 <= 7) {
            if ( getComponentColor(chessboard[x + 1][y + 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 1, y + 1));
            }
        }
        if (x+1 >= 0 && x+1 <= 7 && y - 1 >= 0 && y - 1 <= 7) {
            if ( getComponentColor(chessboard[x + 1][y - 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x + 1, y - 1));
            }
        }
        if (x-1 >= 0 && x-1 <= 7 && y + 1 >= 0 && y + 1 <= 7) {
            if ( getComponentColor(chessboard[x - 1][y + 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        if (x-1 >= 0 && x-1 <= 7 && y - 1 >= 0 && y - 1 <= 7) {
            if ( getComponentColor(chessboard[x - 1][y - 1].toString().charAt(0)) != chessColor) {
                moveTo.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        return moveTo;
    }
}