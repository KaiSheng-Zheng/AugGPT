import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(char p, ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        super(p, chessComponents, chessboardPoint);
        this.name=p;
        this.chessComponents=chessComponents;
        this.source=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        int flag1 = 97;
        int flag2 = 90;
        if (name == 'P') {
            if (x == 1) {
                if (chessComponents[x + 2][y].name == '_') {
                    move.add(new ChessboardPoint(x + 2, y));
                }
                if (chessComponents[x + 1][y].name == '_') {
                    move.add(new ChessboardPoint(x + 1, y));
                }
            } else if (x < 7) {
                if (chessComponents[x + 1][y].name == '_') {
                    move.add(new ChessboardPoint(x + 1, y));
                }
            }
            if (x+1 <= 7) {
                if (y - 1 >= 0) {
                    if (chessComponents[x + 1][y - 1].name >= flag1) {
                        move.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y + 1 <= 7) {
                    if (chessComponents[x + 1][y + 1].name >= flag1) {
                        move.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            }
        }

        if (name == 'p') {
            if (x == 6) {
                if (chessComponents[x - 1][y].name == '_') {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x - 2][y].name == '_') {
                    move.add(new ChessboardPoint(x - 2, y));
                }
            } else if (x > 0) {
                if (chessComponents[x - 1][y].name == '_') {
                    move.add(new ChessboardPoint(x - 1, y));
                }
            }
            if (x - 1 >= 0) {
                if (y - 1 >= 0) {
                    if (chessComponents[x - 1][y - 1].name <= flag2) {
                        move.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x - 1][y + 1].name <= flag2) {
                        move.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
            }
        }
        return move;
    }
}