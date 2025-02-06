import java.util.*;

public class KingChessComponent extends ChessComponent implements CanEat {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        super(source, chessColor, name, id);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int sourceX = this.getSource().getX();
        int sourceY = this.getSource().getY();
        for (int dx = -1; dx < 2; ++dx) {
            for (int dy = -1; dy < 2; ++dy) {
                int x = sourceX + dx;
                int y = sourceY + dy;
                if (x != sourceX || y != sourceY) {
                    ChessboardPoint chessboardPoint = this.getSource().offset(dx, dy);
                    if (chessboardPoint != null) {
                        if (this.canEat(x, y)) {
                            chessboardPoints.add(new ChessboardPoint(x, y));
                        }
                    }
                }

            }
        }
        return chessboardPoints;
    }

    @Override
    public boolean canEat(int x, int y) {
        if (!((this.getChessboard()[x][y]) instanceof EmptySlotComponent)) {
            if (this.getChessColor() != this.getChessboard()[x][y].getChessColor()) {
                return true;
            } else
                return false;
        } else
            return true;
    }

}