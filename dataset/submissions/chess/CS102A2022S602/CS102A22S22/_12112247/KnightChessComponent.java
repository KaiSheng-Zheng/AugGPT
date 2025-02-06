import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{//10 kinds
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        //ChessboardPoint source , ChessColor chessColor , char name
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List CanMovePoint = new ArrayList<ChessboardPoint>();
        CanMovePoint.add(canMoveToHelp(-2,-1));
        CanMovePoint.add(canMoveToHelp(-2,1));
        CanMovePoint.add(canMoveToHelp(-1,-2));
        CanMovePoint.add(canMoveToHelp(-1,2));
        CanMovePoint.add(canMoveToHelp(1,-2));
        CanMovePoint.add(canMoveToHelp(1,2));
        CanMovePoint.add(canMoveToHelp(2,-1));
        CanMovePoint.add(canMoveToHelp(2,1));
        List noNullCanMovePoint = new ArrayList<ChessboardPoint>();
        for(int j=0 ; j<CanMovePoint.size();j++){
            if(CanMovePoint.get(j)!=null){
                noNullCanMovePoint.add(CanMovePoint.get(j));
            }
        }
        if(noNullCanMovePoint!=null){
            return noNullCanMovePoint;
        }else{
            return new ArrayList<>();
        }
    }

}
