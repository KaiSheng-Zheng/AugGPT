import java.util.ArrayList;
import java.util.List;


public class QueenChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();

    public QueenChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
        this.name = name;
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMove(i, j) && chick(i, j)) {
                    list.add(new ChessboardPoint(i, j));
                }
            }
        }
        System.out.println(list);
        return list;
    }

    public boolean canMove(int x, int y) {
        ChessboardPoint source = getSource();
        if (source.getX() == x) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), y) + 1;
                 col < Math.max(source.getY(), y); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == y) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), x) + 1;
                 row < Math.max(source.getX(), x); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getX() - x == source.getY() - y) {
            int row = Math.min(source.getX(), x) + 1;
            int col = Math.min(source.getY(), y) + 1;
            for (; row < Math.max(source.getX(), x) && col < Math.max(source.getY(), y); row++, col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getX() - x == y - source.getY()) {
            int row = Math.min(source.getX(), x) + 1;
            int col = Math.max(source.getY(), y) - 1;
            for (; row < Math.max(source.getX(), x) && col > Math.min(source.getY(), y); row++, col--) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean chick(int x, int y) {
        ChessboardPoint source = getSource();
        if (chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptySlotComponent) {
            return true;
        }
        return false;
    }
}

