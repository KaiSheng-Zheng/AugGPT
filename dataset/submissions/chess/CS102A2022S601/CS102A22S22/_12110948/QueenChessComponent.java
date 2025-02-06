import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for(int i = 0;i <= 7;i++){
            for (int j = 0;j <= 7;j++){
                if(noChess(getSource(),Game.getChess(i,j).getSource()) && notSelf(getSource(),i,j)){
                    canMoveTo.add(Game.getChess(i,j).getSource());
                }
            }
        }
        return canMoveTo;
    }
}
