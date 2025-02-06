import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor color, char name){
        setChessColor(color);
        setName(name);
    }

    private ChessColor checkBoardPosition(int x, int y) {
        ChessComponent chess = game.getChess(x, y);
        if (chess.getChessColor() == ChessColor.NONE) {
            return ChessColor.NONE;
        }
        return chess.getChessColor();
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        
        for (int j = getSource().getX() + 1; j < 8; j++) {
            int he = getSource().getX() + getSource().getY();
            if (he - j < 0) {
                break;
            }
            if (checkBoardPosition(j, he - j) == getChessColor()) break;
            result.add(new ChessboardPoint(j, he - j));
            if (checkBoardPosition(j, he - j) != ChessColor.NONE) break;
        }
        
        for (int i = getSource().getX() + 1; i < 8; i++) {
            int cha = getSource().getX() - getSource().getY();
            if (i - cha > 7) {
                break;
            }
            if (checkBoardPosition(i, i - cha) == getChessColor()) break;
            result.add(new ChessboardPoint(i, i - cha));
            if (checkBoardPosition(i, i - cha) != ChessColor.NONE) break;
        }
        
        for (int i = getSource().getX() - 1; i >= 0; i--) {
            int cha = getSource().getX() - getSource().getY();
            if (i - cha < 0) {
                break;
            }
            if (checkBoardPosition(i, i - cha) == getChessColor()) break;
            result.add(new ChessboardPoint(i, i - cha));
            if (checkBoardPosition(i, i - cha) != ChessColor.NONE) break;
        }
        
        for (int j = getSource().getX() - 1; j >= 0; j--) {
            int he = getSource().getX() + getSource().getY();
            if (he - j > 7) {
                break;
            }
            if (checkBoardPosition(j, he - j) == getChessColor()) break;
            result.add(new ChessboardPoint(j, he - j));
            if (checkBoardPosition(j, he - j) != ChessColor.NONE) break;
        }
        result.removeIf(p -> p.getX() < 0 || p.getX() >= 8 || p.getY() < 0 || p.getY() >= 8);
        result.removeIf(p -> checkBoardPosition(p.getX(), p.getY()) == getChessColor());
        return result;
    }



    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
