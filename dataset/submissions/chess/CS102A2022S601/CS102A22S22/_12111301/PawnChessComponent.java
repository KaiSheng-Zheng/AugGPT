import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();
    private ChessColor currentPlayer;

    public PawnChessComponent(ChessboardPoint source, ChessComponent[][] chessComponents, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
        this.name = name;
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
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
        ChessColor currentPlayer=getCurrentPlayer();
        if (source.getY() == y) {
            if (currentPlayer == ChessColor.BLACK) {
                if (source.getX() == 1) {
                    return (source.getX() - x == -1 || source.getX() - x == -2) && (chessComponents[x][y] instanceof EmptySlotComponent);
                } else {
                    if (source.getX() - x != -1) {
                        return false;
                    }
                }
            }
            if (currentPlayer == ChessColor.WHITE) {
                if (source.getX() == 6) {
                    return (source.getX() - x == 1 || source.getX() - x == 2) && (chessComponents[x][y] instanceof EmptySlotComponent);
                } else {
                    if (source.getX() - x != 1) {
                        return false;
                    }
                }
            }
            return chessComponents[x][y] instanceof EmptySlotComponent;
        } else if (Math.abs(source.getY() - y) == 1) {
            if (currentPlayer== ChessColor.BLACK && source.getX() - x == -1 && !(chessComponents[x][y] instanceof EmptySlotComponent)) {
                return true;
            }
            return currentPlayer == ChessColor.WHITE && source.getX() - x == 1 && !(chessComponents[x][y] instanceof EmptySlotComponent);
        } else {
            return false;
        }
    }

    public boolean chick(int x, int y) {
        ChessboardPoint source = getSource();
        return chessComponents[x][y].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor() || chessComponents[x][y] instanceof EmptySlotComponent;
    }



}


