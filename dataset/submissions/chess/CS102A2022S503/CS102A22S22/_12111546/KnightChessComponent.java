import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> returnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(new ChessboardPoint(i, j)))
                    returnList.add(new ChessboardPoint(i, j));
            }
        }
        return returnList;
    }

    public boolean canMoveTo(ChessboardPoint destination) {
        ChessboardPoint source = this.getSource();
        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        for (int[] a : directions) {
            if (source.getX() + a[0] == destination.getX() && source.getY() + a[1] == destination.getY()
                    && source.getX() + a[0] >= 0 && source.getX() + a[0] < 8 && source.getY() + a[1] >= 0 &&
                    source.getY() + a[1] < 8 &&
                    game.getChess(source.getX() + a[0], source.getY() + a[1]).getChessColor() != getChessColor())
                return true;
        }
        return false;
    }
}
