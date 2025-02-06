import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> p = new ArrayList<>();
        ChessboardPoint P = getSource();
        int x = P.getX();
        int y = P.getY();
        if (ConcreteChessGame.geta()[x][y].name == 'P') {
            if (x == 1) {
                if(ConcreteChessGame.geta()[x + 1][y].getChessColor() == ChessColor.NONE&& ConcreteChessGame.geta()[x + 2][y].getChessColor() == ChessColor.NONE)
                {p.add(new ChessboardPoint(x + 2, y));}
            }
                if (P.offset(+1, 0) != null && ConcreteChessGame.geta()[x + 1][y].getChessColor() == ChessColor.NONE) {
                    p.add(new ChessboardPoint(x + 1, y));
                }
            if (P.offset(+1, +1) != null && ConcreteChessGame.geta()[x + 1][y+1].getChessColor() == ChessColor.WHITE) {
                p.add(new ChessboardPoint(x + 1, y+1));
            }
            if (P.offset(+1, -1) != null && ConcreteChessGame.geta()[x + 1][y-1].getChessColor() == ChessColor.WHITE) {
                p.add(new ChessboardPoint(x + 1, y-1));
            }
        } else if (ConcreteChessGame.geta()[x][y].name == 'p') {
            if (x == 6) {
                if(ConcreteChessGame.geta()[x - 1][y].getChessColor() == ChessColor.NONE&& ConcreteChessGame.geta()[x - 2][y].getChessColor() == ChessColor.NONE)
                {p.add(new ChessboardPoint(x - 2, y));}
            }
                if (P.offset(-1, 0) != null && ConcreteChessGame.geta()[x - 1][y].getChessColor() == ChessColor.NONE) {
                    p.add(new ChessboardPoint(x - 1, y));
            }
            if (P.offset(-1, +1) != null && ConcreteChessGame.geta()[x - 1][y+1].getChessColor() == ChessColor.BLACK) {
                p.add(new ChessboardPoint(x - 1, y+1));
            }
            if (P.offset(-1, -1) != null && ConcreteChessGame.geta()[x - 1][y-1].getChessColor() == ChessColor.BLACK) {
                p.add(new ChessboardPoint(x - 1, y-1));
            }
        }
        return p;
    }
}


