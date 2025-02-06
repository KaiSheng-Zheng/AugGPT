import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);

        if (chessColor == ChessColor.BLACK) {
            this.name = 'R';
        } else {
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> mucTieu = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int x = source.getX();
        int y = source.getY();

        for (int i = 1; i < 8; i++) {
            if (checkNotFriend(x - i, y)) {
                mucTieu.add(new ChessboardPoint(x - i, y));
            }
            if (!checkEmpty(x - i, y)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (checkNotFriend(x + i, y)) {
                mucTieu.add(new ChessboardPoint(x + i, y));
            }
            if (!checkEmpty(x + i, y)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (checkNotFriend(x, y - i)) {
                mucTieu.add(new ChessboardPoint(x, y - i));
            }
            if (!checkEmpty(x, y - i)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            if (checkNotFriend(x, y + i)) {
                mucTieu.add(new ChessboardPoint(x, y + i));
            }
            if (!checkEmpty(x, y + i)) {
                break;
            }
        }

        return mucTieu;
    }

    public boolean checkNotFriend (int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (ConcreteChessGame.I.getChess(x, y).getChessColor() == this.getChessColor()) {
            return false;
        }
        return true;
    }

    public boolean checkEmpty (int x, int y){
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (ConcreteChessGame.I.getChess(x, y).getChessColor() == ChessColor.NONE) {
            return true;
        }
        return false;
    }
}