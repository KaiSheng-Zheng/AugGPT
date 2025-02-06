import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();


    public KingChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackKing = new ArrayList();
        ArrayList<ChessboardPoint> WhiteKing = new ArrayList();

        int x = getSource().getX();
        int y = getSource().getY();

        if (name == 'K') {
            if (x - 1 >= 0 && (Chess[x - 1][y].name == '_' || Chess[x - 1][y].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x - 1, y));
            }
            if (x - 1 >= 0 && y - 1 >= 0 && (Chess[x - 1][y - 1].name == '_' || Chess[x - 1][y - 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (y - 1 >= 0 && (Chess[x][y - 1].name == '_' || Chess[x][y - 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x, y - 1));
            }
            if (x + 1 <= 7 && y - 1 >= 0 && (Chess[x + 1][y - 1].name == '_' || Chess[x + 1][y - 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x + 1, y - 1));
            }
            if (x + 1 <= 7 && (Chess[x + 1][y].name == '_' || Chess[x + 1][y].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x + 1, y));
            }
            if (x + 1 <= 7 && y + 1 <= 7 && (Chess[x + 1][y + 1].name == '_' || Chess[x + 1][y + 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (y + 1 <= 7 && (Chess[x][y + 1].name == '_' || Chess[x][y + 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x, y + 1));
            }
            if (x - 1 >= 0 && y + 1 <= 7 && (Chess[x - 1][y + 1].name == '_' || Chess[x - 1][y + 1].getChessColor() == ChessColor.WHITE)) {
                BlackKing.add(new ChessboardPoint(x - 1, y + 1));
            }
        }

        if (name == 'k') {
            if (x - 1 >= 0 && (Chess[x - 1][y].name == '_' || Chess[x - 1][y].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x - 1, y));
            }
            if (x - 1 >= 0 && y - 1 >= 0 && (Chess[x - 1][y - 1].name == '_' || Chess[x - 1][y - 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (y - 1 >= 0 && (Chess[x][y - 1].name == '_' || Chess[x][y - 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x, y - 1));
            }
            if (x + 1 <= 7 && y - 1 >= 0 && (Chess[x + 1][y - 1].name == '_' || Chess[x + 1][y - 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x + 1, y - 1));
            }
            if (x + 1 <= 7 && (Chess[x + 1][y].name == '_' || Chess[x + 1][y].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x + 1, y));
            }
            if (x + 1 <= 7 && y + 1 <= 7 && (Chess[x + 1][y + 1].name == '_' || Chess[x + 1][y + 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (y + 1 <= 7 && (Chess[x][y + 1].name == '_' || Chess[x][y + 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x, y + 1));
            }
            if (x - 1 >= 0 && y + 1 <= 7 && (Chess[x - 1][y + 1].name == '_' || Chess[x - 1][y + 1].getChessColor() == ChessColor.BLACK)) {
                WhiteKing.add(new ChessboardPoint(x - 1, y + 1));
            }
        }


        if (name == 'K') {
            return BlackKing;
        } else if (name == 'k') {
            return WhiteKing;
        } else {
            return new ArrayList<>();
        }
    }
}
