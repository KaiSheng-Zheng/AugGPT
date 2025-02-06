import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (notPrevented(Game.getChess(i,j).getSource())
                        && Game.getChess(i,j).getChessColor() != getChessColor()){
                    list.add(Game.getChess(i,j).getSource());
                }
            }
        }
        return list;
    }
}
