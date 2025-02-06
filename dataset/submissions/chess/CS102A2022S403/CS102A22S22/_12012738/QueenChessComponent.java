import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(int i, int j, ChessColor color, char q) {
        super(i, j, color, q);
    }

    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> point = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (x + i == 8) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x + i][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y));
                }
                if (chessboard[x + i][y].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x + i, y));
                    break;
                }
                if (chessboard[x + i][y].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x + i][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y));
                }
                if (chessboard[x + i][y].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x + i, y));
                    break;
                }
                if (chessboard[x + i][y].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i == -1) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x - i][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y));
                }
                if (chessboard[x - i][y].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x - i, y));
                    break;
                }
                if (chessboard[x - i][y].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x - i][y].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y));
                }
                if (chessboard[x - i][y].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x - i, y));
                    break;
                }
                if (chessboard[x - i][y].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (y + i == 8) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x, y + i));
                }
                if (chessboard[x][y + i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x, y + i));
                    break;
                }
                if (chessboard[x][y + i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x, y + i));
                }
                if (chessboard[x][y + i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x, y + i));
                    break;
                }
                if (chessboard[x][y + i].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (y - i == -1) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x, y - i));
                }
                if (chessboard[x][y - i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x, y - i));
                    break;
                }
                if (chessboard[x][y - i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x, y - i));
                }
                if (chessboard[x][y - i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x, y - i));
                    break;
                }
                if (chessboard[x][y - i].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x + i == 8 || y + i == 8) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y + i));
                }
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x + i, y + i));
                    break;
                }
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y + i));
                }
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x + i, y + i));
                    break;
                }
                if (chessboard[x + i][y + i].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x + i == 8 || y - i == -1) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y - i));
                }
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x + i, y - i));
                    break;
                }
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x + i, y - i));
                }
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x + i, y - i));
                    break;
                }
                if (chessboard[x + i][y - i].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i == -1 || y - i == -1) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y - i));
                }
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x - i, y - i));
                    break;
                }
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y - i));
                }
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x - i, y - i));
                    break;
                }
                if (chessboard[x - i][y - i].getChessColor() == ChessColor.WHITE) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i == -1 || y + i == 8) {
                break;
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y + i));
                }
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.WHITE) {
                    point.add(new ChessboardPoint(x - i, y + i));
                    break;
                }
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.BLACK) {
                    break;
                }
            }
            if (this.getChessColor() == ChessColor.WHITE) {
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.NONE) {
                    point.add(new ChessboardPoint(x - i, y + i));
                }
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.BLACK) {
                    point.add(new ChessboardPoint(x - i, y + i));
                    break;
                }
                if (chessboard[x - i][y + i].getChessColor() == ChessColor.WHITE) {
                    break;
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