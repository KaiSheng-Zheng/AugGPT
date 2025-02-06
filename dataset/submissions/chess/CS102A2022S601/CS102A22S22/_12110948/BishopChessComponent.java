import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(Math.abs(getSource().getX() - i) == Math.abs(getSource().getY() - j)
                        && canSlope(getSource(),Game.getChess(i,j).getSource())
                        && notSelf(getSource(),i,j)){
                    canMoveTo.add(Game.getChess(i,j).getSource());
                }
            }
        }
        return canMoveTo;
    }
}
