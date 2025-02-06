import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public KnightChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackKnight = new ArrayList();
        ArrayList<ChessboardPoint> WhiteKnight = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();
        if (name == 'N') {
            if (x - 1 >= 0 && y - 2 >= 0 && (Chess[x - 1][y - 2].name == '_' || Chess[x - 1][y - 2].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x - 1, y - 2));
            }
            if (x + 1 <= 7 && y - 2 >= 0 && (Chess[x + 1][y - 2].name == '_' || Chess[x + 1][y - 2].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x + 1, y - 2));
            }
            if (x + 2 <= 7 && y - 1 >= 0 && (Chess[x + 2][y - 1].name == '_' || Chess[x + 2][y - 1].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x + 2, y - 1));
            }
            if (x + 2 <= 7 && y + 1 <= 7 && (Chess[x + 2][y + 1].name == '_' || Chess[x + 2][y + 1].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x + 2, y + 1));
            }
            if (x + 1 <= 7 && y + 2 <= 7 && (Chess[x + 1][y + 2].name == '_' || Chess[x + 1][y + 2].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x + 1, y + 2));
            }
            if (x - 1 >= 0 && y + 2 <= 7 && (Chess[x - 1][y + 2].name == '_' || Chess[x - 1][y + 2].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x - 1, y + 2));
            }
            if (x - 2 >= 0 && y + 1 <= 7 && (Chess[x - 2][y + 1].name == '_' || Chess[x - 2][y + 1].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x - 2, y + 1));
            }
            if (x - 2 >= 0 && y - 1 >= 0 && (Chess[x - 2][y - 1].name == '_' || Chess[x - 2][y - 1].getChessColor() == ChessColor.WHITE)) {
                BlackKnight.add(new ChessboardPoint(x - 2, y - 1));
            }
        }
        if (name == 'n') {
            if (x - 1 >= 0 && y - 2 >= 0 && (Chess[x - 1][y - 2].name == '_' || Chess[x - 1][y - 2].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x - 1, y - 2));
            }
            if (x - 1 >= 0 && y - 2 >= 0 && (Chess[x - 1][y - 2].name == '_' || Chess[x - 1][y - 2].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x - 1, y - 2));
            }
            if (x + 1 <= 7 && y - 2 >= 0 && (Chess[x + 1][y - 2].name == '_' || Chess[x + 1][y - 2].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x + 1, y - 2));
            }
            if (x + 2 <= 7 && y - 1 >= 0 && (Chess[x + 2][y - 1].name == '_' || Chess[x + 2][y - 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x + 2, y - 1));
            }
            if (x + 2 <= 7 && y + 1 <= 7 && (Chess[x + 2][y + 1].name == '_' || Chess[x + 2][y + 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x + 2, y + 1));
            }
            if (x + 1 <= 7 && y + 2 <= 7 && (Chess[x + 1][y + 2].name == '_' || Chess[x + 1][y + 2].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x + 1, y + 2));
            }
            if (x - 1 >= 0 && y + 2 <= 7 && (Chess[x - 1][y + 2].name == '_' || Chess[x - 1][y + 2].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x - 1, y + 2));
            }
            if (x - 2 >= 0 && y + 1 <= 7 && (Chess[x - 2][y + 1].name == '_' || Chess[x - 2][y + 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x - 2, y + 1));
            }
            if (x - 2 >= 0 && y - 1 >= 0 && (Chess[x - 2][y - 1].name == '_' || Chess[x - 2][y - 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKnight.add(new ChessboardPoint(x - 2, y - 1));
            }
        }


        if (name == 'N') {
            return BlackKnight;
        } else if (name == 'n') {
            return WhiteKnight;
        } else {
            return new ArrayList<>();
        }

    }
}
