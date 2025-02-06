import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);

        if (chessColor == ChessColor.BLACK) {
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> mucTieu = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        for (int i = source.getX() - 1; i <= source.getX() + 1; i++) {
            for (int j = source.getY() - 1; j <= source.getY() + 1; j++) {
                if (checkNotFriend(i, j)) {
                    mucTieu.add(new ChessboardPoint(i, j));
                }
            }
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
