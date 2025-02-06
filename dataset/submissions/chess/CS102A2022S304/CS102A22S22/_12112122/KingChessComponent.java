import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor chessColor, ChessComponent[][] chessComponents) {
        super(chessComponents);
        setChessColor(chessColor);
    }

    @Override
    public String toString() {
        switch (getChessColor()) {
            case BLACK:
                return "K";
            case WHITE:
                return "k";
            default:
                return "_";
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX(), y = getSource().getY();
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                boolean can = true;
                ChessComponent destination = chessComponents[i][j];
                int x1 = destination.getSource().getX(), y1 = destination.getSource().getY();
                if ((x == x1 && y == y1) || Math.abs(x - x1) > 1 || Math.abs(y - y1) > 1) can = false;
                if (can && canEat(this, destination)) canMove.add(new ChessboardPoint(i, j));
            }
        }
        return canMove;
    }
}