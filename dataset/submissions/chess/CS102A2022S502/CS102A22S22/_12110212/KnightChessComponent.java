import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (x - 2 >= 0 && x - 2 <= 7 && y + 1 >= 0 && y + 1 <= 7 && chessComponents[x - 2][y + 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y + 2 >= 0 && y + 2 <= 7 && chessComponents[x - 1][y + 2].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y + 2 >= 0 && y + 2 <= 7 && chessComponents[x + 1][y + 2].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (x + 2 >= 0 && x + 2 <= 7 && y + 1 >= 0 && y + 1 <= 7 && chessComponents[x + 2][y + 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 2, y + 1));
        }
        if (x + 2 >= 0 && x + 2 <= 7 && y - 1 >= 0 && y - 1 <= 7 && chessComponents[x + 2][y - 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (x + 1 >= 0 && x + 1 <= 7 && y - 2 >= 0 && y - 2 <= 7 && chessComponents[x + 1][y - 2].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 1, y - 2));
        }
        if (x - 1 >= 0 && x - 1 <= 7 && y - 2 >= 0 && y - 2 <= 7 && chessComponents[x - 1][y - 2].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 1, y - 2));
        }
        if (x - 2 >= 0 && x - 2 <= 7 && y - 1 >= 0 && y - 1 <= 7 && chessComponents[x - 2][y - 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 2, y - 1));
        }
        return canMoveTo;
    }

    public KnightChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.setSource(point);
        this.setChessColor(color);
        this.setName(name);
    }
}
