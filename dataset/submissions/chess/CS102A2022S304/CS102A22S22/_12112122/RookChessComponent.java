import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor chessColor, ChessComponent[][] chessComponents) {
        super(chessComponents);
        setChessColor(chessColor);
    }

    @Override
    public String toString() {
        switch (getChessColor()) {
            case BLACK:
                return "R";
            case WHITE:
                return "r";
            default:
                return "_";
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX(), y = getSource().getY();
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean can = true;
                ChessComponent destination = chessComponents[i][j];
                int x1 = destination.getSource().getX(), y1 = destination.getSource().getY();
                if (x == x1) {
                    for (int k = Math.min(y, y1) + 1; k < Math.max(y, y1); k++) {
                        if (!(chessComponents[x][k] instanceof EmptySlotComponent)) {
                            can = false;
                            break;
                        }
                    }
                } else if (y == y1) {
                    for (int k = Math.min(x, x1)+1; k < Math.max(x, x1); k++) {
                        if (!(chessComponents[k][y] instanceof EmptySlotComponent)) {
                            can = false;
                            break;
                        }
                    }
                } else can = false;
                if (can && canEat(this, destination)) canMove.add(new ChessboardPoint(i, j));
            }
        }
        return canMove;
    }
}