import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public PawnChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackPawn = new ArrayList();
        ArrayList<ChessboardPoint> WhitePawn = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'P') {
            if (x == 1) {
                if (Chess[x + 1][y].name == '_' && Chess[x + 2][y].name != '_') {
                    BlackPawn.add(new ChessboardPoint(x + 1, y));
                }
                if (Chess[x + 1][y].name == '_' && Chess[x + 2][y].name == '_') {
                    BlackPawn.add(new ChessboardPoint(x + 1, y));
                    BlackPawn.add(new ChessboardPoint(x + 2, y));
                }
                if (Chess[x + 1][y + 1].getChessColor() == ChessColor.WHITE && y + 1 <= 7) {
                    BlackPawn.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (Chess[x + 1][y - 1].getChessColor() == ChessColor.WHITE && y - 1 >= 0) { // y - 1 >= 0 should be placed before the &&, otherwise the check is meaningless
                    BlackPawn.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (x > 1) {
                if (Chess[x + 1][y].name == '_' && x + 1 <= 7) {
                    BlackPawn.add(new ChessboardPoint(x + 1, y));
                }
                if (Chess[x + 1][y + 1].getChessColor() == ChessColor.WHITE && x + 1 <= 7 && y + 1 <= 7) {
                    BlackPawn.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (Chess[x + 1][y - 1].getChessColor() == ChessColor.WHITE && x + 1 <= 7 && y - 1 >= 0) {
                    BlackPawn.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
        }

        if (name == 'p') {
            if (x == 6) {
                if (Chess[x - 1][y].name == '_' && Chess[x - 2][y].name != '_') {
                    WhitePawn.add(new ChessboardPoint(x - 1, y));
                }
                if (Chess[x - 1][y].name == '_' && Chess[x + 2][y].name == '_') {
                    WhitePawn.add(new ChessboardPoint(x + 1, y));
                    WhitePawn.add(new ChessboardPoint(x + 2, y));
                }
                if (Chess[x - 1][y + 1].getChessColor() == ChessColor.BLACK && y + 1 <= 7) {
                    WhitePawn.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (Chess[x - 1][y - 1].getChessColor() == ChessColor.BLACK && y - 1 >= 0) {
                    WhitePawn.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (x < 6) {
                if (Chess[x - 1][y].name == '_' && x - 1 >= 0) {
                    WhitePawn.add(new ChessboardPoint(x + 1, y));
                }
                if (Chess[x - 1][y + 1].getChessColor() == ChessColor.BLACK && x - 1 >= 0 && y + 1 <= 7) {
                    WhitePawn.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (Chess[x - 1][y - 1].getChessColor() == ChessColor.BLACK && x - 1 >= 0 && y - 1 >= 0) {
                    WhitePawn.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
        }


        if (name == 'P') {
            return BlackPawn;
        } else if (name == 'p') {
            return WhitePawn;
        } else {
            return new ArrayList<>();
        }
    }
}