import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent implements CanEat{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);

    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        super(source, chessColor, name, id);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int sourceX = this.getSource().getX();
        int sourceY = this.getSource().getY();
        for (int dc = 1; dc <= Math.min(7 - sourceX, 7 - sourceY); dc++) {
            int y = sourceY + dc;
            int x = sourceX + dc;
            if (this.canEat(x, y)) {
                chessboardPoints.add(new ChessboardPoint(x, y));
            } else if (this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y));
                break;
            } else
                break;
        }
        for (int dc = 1; dc <= Math.min(sourceX, sourceY); dc++) {
            int y = sourceY - dc;
            int x = sourceX - dc;
            if (this.canEat(x, y)) {
                chessboardPoints.add(new ChessboardPoint(x, y));
            } else if (this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y));
                break;
            } else
                break;

        }
        for (int dc = 1; dc <= Math.min(7 - sourceY, sourceX); dc++) {
            int y = sourceY + dc;
            int x = sourceX - dc;
            if (this.canEat(x, y)) {
                chessboardPoints.add(new ChessboardPoint(x, y));
            } else if (this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y));
                break;
            } else
                break;
        }
        for (int dc = 1; dc <= Math.min(7 - sourceX, sourceY); dc++) {
            int y = sourceY - dc;
            int x = sourceX + dc;
            if (this.canEat(x, y)) {
                chessboardPoints.add(new ChessboardPoint(x, y));
            } else if (this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, y));
                break;
            } else
                break;
        }
        return chessboardPoints;
    }

    @Override
    public boolean canEat(int x, int y) {
        if ((this.getChessboard()[x][y]) instanceof EmptySlotComponent) {
            return true;
        } else
            return false;
    }
}