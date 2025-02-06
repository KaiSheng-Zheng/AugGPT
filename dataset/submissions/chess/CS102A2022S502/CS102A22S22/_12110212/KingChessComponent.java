import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (x - 1 >= 0 && chessComponents[x - 1][y].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 1, y));
        }
        if (y + 1 < 8 && x - 1 >= 0 && chessComponents[x - 1][y + 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (y + 1 < 8 && chessComponents[x][y + 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x, y + 1));
        }
        if (x + 1 < 8 && y + 1 < 8 && chessComponents[x + 1][y + 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 1, y + 1));
        }
        if (x + 1 < 8 && chessComponents[x + 1][y].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 1, y));
        }
        if (x + 1 < 8 && y - 1 >= 0 && chessComponents[x + 1][y - 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (y - 1 >= 0 && chessComponents[x][y - 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x, y - 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0 && chessComponents[x - 1][y - 1].getChessColor() != this.getChessColor()) {
            canMoveTo.add(new ChessboardPoint(x - 1, y - 1));
        }

        return canMoveTo;
    }

    public KingChessComponent(ChessboardPoint point, ChessColor color, char name) {
        this.setSource(point);
        this.setChessColor(color);
        this.setName(name);
    }
}
