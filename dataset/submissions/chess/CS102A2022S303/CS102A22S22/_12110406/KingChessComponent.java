import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
        super(name, chessColor, source);
    }
    public boolean Move(int x, int y) {
        int a = 0;
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            if (chessComponents[x][y].getChessColor() == ChessColor.NONE) {
                a = 1;
            }
            if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                a = 2;
            }
            if (chessComponents[x][y].getChessColor() != this.getChessColor()) {
                a = 1;
            }
        } else {
            a = 2;
        }
        if (a == 1) {
            return true;
        } else return false;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointArrayList = new ArrayList<>();
        int X = this.getSource().getX();
        int Y = this.getSource().getY();
        if (Move(X + 1, Y)) {
            chessboardPointArrayList.add(new ChessboardPoint(X + 1, Y));
        }
        if (Move(X - 1, Y)) {
            chessboardPointArrayList.add(new ChessboardPoint(X - 1, Y));
        }
        if (Move(X + 1, Y + 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X + 1, Y + 1));
        }
        if (Move(X + 1, Y - 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X + 1, Y - 1));
        }
        if (Move(X - 1, Y + 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X - 1, Y + 1));
        }
        if (Move(X - 1, Y - 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X - 1, Y - 1));
        }
        if (Move(X, Y + 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X, Y + 1));
        }
        if (Move(X, Y - 1)) {
            chessboardPointArrayList.add(new ChessboardPoint(X, Y - 1));
        }
        return chessboardPointArrayList;
    }
}
