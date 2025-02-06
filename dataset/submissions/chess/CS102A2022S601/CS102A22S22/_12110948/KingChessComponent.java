import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(inGraph(getSource(),i,j) && notSelf(getSource(),getSource().getX()+i,getSource().getY()+j)){
                    canMoveTo.add(Game.getChess(getSource().getX() + i,getSource().getY() + j).getSource());
                }
            }
        }
        return canMoveTo;
    }
}
