import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessColor color, char name){
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
        
        for (int i = getSource().getY() + 1; i < 8; i++) {
            if (checkBoardPosition(getSource().getX(), i) == getChessColor()) break;
            result.add(new ChessboardPoint(getSource().getX(), i));
            if (checkBoardPosition(getSource().getX(), i) != ChessColor.NONE) break;
        }
        
        for (int i = getSource().getY() - 1; i >= 0; i--) {
            if (checkBoardPosition(getSource().getX(), i) == getChessColor()) break;
            result.add(new ChessboardPoint(getSource().getX(), i));
            if (checkBoardPosition(getSource().getX(), i) != ChessColor.NONE) break;
        }
        
        for (int i = getSource().getX() + 1; i < 8; i++) {
            if (checkBoardPosition(i, getSource().getY()) == getChessColor()) break;
            result.add(new ChessboardPoint(i, getSource().getY()));
            if (checkBoardPosition(i, getSource().getY()) != ChessColor.NONE) break;
        }
        
        for (int i = getSource().getX() - 1; i >= 0; i--) {
            if (checkBoardPosition(i, getSource().getY()) == getChessColor()) break;
            result.add(new ChessboardPoint(i, getSource().getY()));
            if (checkBoardPosition(i, getSource().getY()) != ChessColor.NONE) break;
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
