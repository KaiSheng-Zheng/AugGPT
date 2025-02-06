import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    ChessColor chessColor;
    char name;

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
        this.chessColor = chessColor;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int rightdown = Math.min(7 - x, 7 - y);
        int rightup = Math.min(x, 7 - y);
        int leftdown = Math.min(7 - x, y);
        int leftup = Math.min(x, y);
        boolean valid = true;
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            valid = false;
        }
        if (valid) {
            for (int i = 1; i <= rightdown; i++) {
                if (board[x + i][y + i].name != '_') {
                    if (board[x + i][y + i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x + i, y + i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    list.add(new ChessboardPoint(x + i, y + i));
                }
            }
            for (int i = 1; i <= rightup; i++) {
                if (board[x - i][y + i].name != '_') {
                    if (board[x - i][y + i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x - i, y + i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    list.add(new ChessboardPoint(x - i, y + i));
                }
            }
            for (int i = 1; i <= leftdown; i++) {
                if (board[x + i][y - i].name != '_') {
                    if (board[x + i][y - i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x + i, y - i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    list.add(new ChessboardPoint(x + i, y - i));
                }
            }
            for (int i = 1; i <= leftup; i++) {
                if (board[x - i][y - i].name != '_') {
                    if (board[x - i][y - i].getChessColor() != chessColor) {
                        list.add(new ChessboardPoint(x - i, y - i));
                        break;
                    } else {
                        break;
                    }
                } else {
                    list.add(new ChessboardPoint(x - i, y - i));
                }
            }
        }


        return list;
    }

//    @Override
//    public ChessComponent copy(int x, int y) {
//        return new BishopChessComponent(new ChessboardPoint(x, y), this.chessColor, this.name);
//    }
}
