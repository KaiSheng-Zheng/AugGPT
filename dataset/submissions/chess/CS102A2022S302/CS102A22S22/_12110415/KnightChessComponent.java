import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint point,ChessColor chessColor,char name){
        super(point,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> needToReturn=new ArrayList<>();
        if (super.getSource().offset(-1,2)!=null){
        needToReturn.add(super.getSource().offset(-1,2));
        }
        if (super.getSource().offset(1,2)!=null){
            needToReturn.add(super.getSource().offset(1,2));
        }
        if (super.getSource().offset(-1,-2)!=null){
            needToReturn.add(super.getSource().offset(-1,-2));
        }
        if (super.getSource().offset(-1,-2)!=null){
            needToReturn.add(super.getSource().offset(-1,-2));
        }
        if (super.getSource().offset(2,1)!=null){
            needToReturn.add(super.getSource().offset(2,1));
        }
        if (super.getSource().offset(2,-1)!=null){
            needToReturn.add(super.getSource().offset(2,-1));
        }
        if (super.getSource().offset(-2,1)!=null){
            needToReturn.add(super.getSource().offset(-2,1));
        }
        if (super.getSource().offset(-2,-1)!=null){
            needToReturn.add(super.getSource().offset(-2,-1));
        }
        return needToReturn;
    }
}
