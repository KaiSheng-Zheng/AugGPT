import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (notOut(getSource(),i,j)
                        && Game.getChess(getSource().getX() + i,getSource().getY() + j).getChessColor() != getChessColor()){
                    list.add(Game.getChess(getSource().getX() + i,getSource().getY() + j).getSource());
                }
            }
        }
        return list;
    }
}
