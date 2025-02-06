import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint point,ChessColor chessColor,char name){
        super(point,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> needToReturn=new ArrayList<>();

        if (super.getChessColor().equals(ChessColor.BLACK)) {
            for (int dy = 1; dy < 2; dy++) {
                for (int dx = -1; dx < 2; dx++) {
                    if (super.getSource().offset(dx, dy)!=null){
                        needToReturn.add(super.getSource().offset(dx,dy));
                    }
                }
            }
            return needToReturn;
        }
        else{
            for (int dy = -1; dy < 0; dy++) {
                for (int dx = -1; dx < 2; dx++) {
                    if (super.getSource().offset(dx, dy)!=null){
                        needToReturn.add(super.getSource().offset(dx,dy));
                    }
                }
            }
            return needToReturn;
        }
    }
}
