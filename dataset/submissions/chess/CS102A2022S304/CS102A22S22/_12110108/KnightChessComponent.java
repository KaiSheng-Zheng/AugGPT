import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent implements CanEat{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, int id) {
        super(source, chessColor, name, id);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int dx = -1; dx < 2; dx += 2) {
            for (int dy = -2; dy < 3; dy += 4) {
                ChessboardPoint chessboardPoint = this.getSource().offset(dx, dy);
                if (chessboardPoint != null) {
                    int x = chessboardPoint.getX();
                    int y = chessboardPoint.getY();
                    if (this.getChessboard()[x][y].getChessColor() == ChessColor.NONE ||
                            this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(chessboardPoint);
                    }
                }
            }
        }
        for (int dy = -1; dy < 2; dy += 2) {
            for (int dx = -2; dx < 3; dx += 4) {
                ChessboardPoint chessboardPoint = this.getSource().offset(dx, dy);
                if (chessboardPoint != null) {
                    int x = chessboardPoint.getX();
                    int y = chessboardPoint.getY();
                    if (this.getChessboard()[x][y].getChessColor() == ChessColor.NONE ||
                            this.getChessboard()[x][y].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(chessboardPoint);
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