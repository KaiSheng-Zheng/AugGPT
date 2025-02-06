import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent implements CanEat {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);

    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        super(source, chessColor, name, id);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int sourceX = this.getSource().getX();
        int sourceY = this.getSource().getY();
        for (int dx = 1; dx <= sourceX; dx++) {
            int x = sourceX - dx;
            if (this.canEat(x, sourceY)) {
                chessboardPoints.add(new ChessboardPoint(x, sourceY));
            } else if (this.getChessboard()[x][sourceY].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, sourceY));
                break;
            } else {
                break;
            }
        }
        for (int dx = 1; dx <= (7 - sourceX); dx++) {
            int x = sourceX + dx;
            if (this.canEat(x, sourceY)) {
                chessboardPoints.add(new ChessboardPoint(x, sourceY));
            } else if (this.getChessboard()[x][sourceY].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(x, sourceY));
                break;
            } else
                break;
        }
        for (int dy = 1; dy <= sourceY; dy++) {
            int y = sourceY - dy;
            if (this.canEat(sourceX, y)) {
                chessboardPoints.add(new ChessboardPoint(sourceX, y));
            } else if (this.getChessboard()[sourceX][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(sourceX, y));
                break;
            } else
                break;
        }
        for (int dy = 1; dy <= (7 - sourceY); dy++) {
            int y = sourceY + dy;
            if (this.canEat(sourceX, y)) {
                chessboardPoints.add(new ChessboardPoint(sourceX, y));
            } else if (this.getChessboard()[sourceX][y].getChessColor() != this.getChessColor()) {
                chessboardPoints.add(new ChessboardPoint(sourceX, y));
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
