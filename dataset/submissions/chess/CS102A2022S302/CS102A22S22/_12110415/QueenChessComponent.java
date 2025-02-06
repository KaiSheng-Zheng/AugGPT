import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint point, ChessColor chessColor, char name) {
        super(point, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> needToReturn = new ArrayList<>();
        for (int dx = -7; dx <8 ; dx++) {
            if (super.getSource().offset(dx,0)!=null){
                needToReturn.add(super.getSource().offset(dx,0));
            }
            if (super.getSource().offset(dx,dx)!=null){
                needToReturn.add(super.getSource().offset(dx,dx));
            }
        }
        for (int dy = -7; dy <8; dy++) {
            if (super.getSource().offset(0,dy)!=null){
                needToReturn.add(super.getSource().offset(0,dy));
            }
        }
        while (needToReturn.contains(super.getSource())){
            needToReturn.remove(super.getSource());
        }
        return needToReturn;
    }
}
