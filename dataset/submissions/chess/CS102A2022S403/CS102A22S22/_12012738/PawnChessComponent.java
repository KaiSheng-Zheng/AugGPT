import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int i, int j, ChessColor color, char p) {
        super(i, j, color, p);
    }

    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> point = new ArrayList<>();
        if (this.getChessColor() == ChessColor.WHITE) {
            int k = x - 1;
            if (k >= 0) {
                if (chessboard[k][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(k, y));
                }
                if (y - 1 >= 0) {
                    if (chessboard[k][y - 1].getChessColor() == ChessColor.BLACK) {
                        point.add(new ChessboardPoint(k, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessboard[k][y + 1].getChessColor() == ChessColor.BLACK) {
                        point.add(new ChessboardPoint(k, y + 1));
                    }
                }
            }
            if (x == 6) {
                if (chessboard[4][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(4, y));
                }
            }
        }
        if (this.getChessColor() == ChessColor.BLACK) {
            int k = x + 1;
            if (k < 8) {
                if (chessboard[k][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(k, y));
                }
                if (y - 1 >= 0) {
                    if (chessboard[k][y - 1].getChessColor() == ChessColor.WHITE) {
                        point.add(new ChessboardPoint(k, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessboard[k][y + 1].getChessColor() == ChessColor.WHITE) {
                        point.add(new ChessboardPoint(k, y + 1));
                    }
                }
            }
            if (x == 1) {
                if (chessboard[3][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(3, y));
                }
            }
        }
        List<ChessboardPoint> point1 = new ArrayList<>();
        if (point.size() != 0) {
            int minX, minY, situation;
            while (point.size() != 0) {
                minX = point.get(0).getX();
                minY = point.get(0).getY();
                situation = 0;
                for (int i = 1; i < point.size(); i++) {
                    if (minX > point.get(i).getX()) {
                        minX = point.get(i).getX();
                        minY = point.get(i).getY();
                        situation = i;
                        continue;
                    }
                    if (minX == point.get(i).getX()) {
                        if (minY > point.get(i).getY()) {
                            minY = point.get(i).getY();
                            situation = i;
                        }
                    }
                }
                point1.add(new ChessboardPoint(minX, minY));
                point.remove(situation);
            }
        }
        return point1;
    }
}