import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint point,ChessColor chessColor,char name){
        super(point,chessColor,name);
    }
    
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> needToReturn=new ArrayList<>();
        for (int dy = -1; dy < 2; dy++) {
            for (int dx = -1; dx < 2; dx++) {
                if (super.getSource().offset(dx,dy)!=null){
                    needToReturn.add(super.getSource().offset(dx,dy));
                }
            }
        }
        while (needToReturn.contains(super.getSource())){
            needToReturn.remove(super.getSource());
        }

        return needToReturn;
    }
}
