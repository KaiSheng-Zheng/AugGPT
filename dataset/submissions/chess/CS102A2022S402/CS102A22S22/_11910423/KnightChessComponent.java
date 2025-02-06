import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);

        if (chessColor == ChessColor.BLACK) {
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> mucTieu = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int x = source.getX();
        int y = source.getY();

        if (checkNotFriend(x - 2, y - 1)) {
            mucTieu.add(new ChessboardPoint(x - 2, y - 1));
        }

        if (checkNotFriend(x - 2, y + 1)) {
            mucTieu.add(new ChessboardPoint(x - 2, y + 1));
        }

        if (checkNotFriend(x + 2, y - 1)) {
            mucTieu.add(new ChessboardPoint(x + 2, y - 1));
        }

        if (checkNotFriend(x + 2, y + 1)) {
            mucTieu.add(new ChessboardPoint(x + 2, y + 1));
        }

        if (checkNotFriend(x - 1, y - 2)) {
            mucTieu.add(new ChessboardPoint(x - 1, y - 2));
        }

        if (checkNotFriend(x - 1, y + 2)) {
            mucTieu.add(new ChessboardPoint(x - 1, y + 2));
        }

        if (checkNotFriend(x + 1, y - 2)) {
            mucTieu.add(new ChessboardPoint(x + 1, y - 2));
        }

        if (checkNotFriend(x + 1, y + 2)) {
            mucTieu.add(new ChessboardPoint(x + 1, y + 2));
        }

        return mucTieu;
    }

    public boolean checkNotFriend(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        if (ConcreteChessGame.I.getChess(x, y).getChessColor() == this.getChessColor()) {
            return false;
        }
        return true;
    }
}
