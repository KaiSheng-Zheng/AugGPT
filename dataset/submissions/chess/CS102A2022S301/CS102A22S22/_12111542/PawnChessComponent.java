import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {



    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        boolean valid = true;
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            valid = false;
        }
        if (valid) {
            if (getChessColor() == ChessColor.BLACK && x + 1 <= 7 && board[x + 1][y].name == '_') {
                list.add(new ChessboardPoint(x + 1, y));
            }
            if (getChessColor() == ChessColor.WHITE && x - 1 >= 0 && board[x - 1][y].name == '_') {
                list.add(new ChessboardPoint(x - 1, y));
            }
            if (x == 6 && getChessColor() == ChessColor.WHITE && board[4][y].name == '_') {
                list.add(new ChessboardPoint(4, y));
            }
            if (x == 1 && getChessColor() == ChessColor.BLACK && board[3][y].name == '_') {
                list.add(new ChessboardPoint(3, y));
            }
            if (getChessColor() == ChessColor.BLACK) {
                if (x + 1 <= 7 && y + 1 <= 7 && board[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                    list.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (x + 1 <= 7 && y - 1 >= 0 && board[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                    list.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (getChessColor() == ChessColor.WHITE) {
                if (x - 1 >= 0 && y + 1 <= 7 && board[x - 1][y + 1].getChessColor() == ChessColor.BLACK) {
                    list.add(new ChessboardPoint(x - 1, y + 1));
                }
                if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                    list.add(new ChessboardPoint(x - 1, y - 1));
                }
            }

        }
        return list;
    }

//    @Override
//    public ChessComponent copy(int x, int y) {
//        return new PawnChessComponent(new ChessboardPoint(x, y), this.getChessColor(), this.name);
//    }
}
