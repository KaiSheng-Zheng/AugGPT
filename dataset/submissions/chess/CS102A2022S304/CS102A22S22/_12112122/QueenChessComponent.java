import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor chessColor, ChessComponent[][] chessComponents) {
        super(chessComponents);
        setChessColor(chessColor);
    }

    @Override
    public String toString() {
        switch (getChessColor()) {
            case BLACK:
                return "Q";
            case WHITE:
                return "q";
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
                } else if (x + y == x1 + y1) {
                    for (int k = Math.min(y, y1) + 1; k < Math.max(y, y1); k++) {
                        if (!(chessComponents[x + y - k][k] instanceof EmptySlotComponent)) {
                            can = false;
                        }
                    }
                } else if (x - y == x1 - y1) {
                    for (int k = Math.min(y, y1) + 1; k < Math.max(y, y1); k++) {
                        if (!(chessComponents[x - y + k][k] instanceof EmptySlotComponent)) {
                            can = false;
                        }
                    }
                } else can = false;
                if (can && canEat(this, destination)) canMove.add(new ChessboardPoint(i, j));
            }
        }
        return canMove;
    }
}