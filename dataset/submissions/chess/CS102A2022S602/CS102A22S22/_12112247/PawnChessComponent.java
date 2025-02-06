import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        //ChessboardPoint source , ChessColor chessColor , char name
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List CanMovePoint = new ArrayList<ChessboardPoint>();
        if(chessColor.equals(ChessColor.BLACK)){
            if(source.getX()==1){
                CanMovePoint.add(canMoveToHelp(1,0));
                CanMovePoint.add(canMoveToHelp(2,0));
                CanMovePoint.add(eatCanMoveTo(1,-1));
                CanMovePoint.add(eatCanMoveTo(1,1));

            }else{
                CanMovePoint.add(canMoveToHelp(1,0));
                CanMovePoint.add(eatCanMoveTo(1,-1));
                CanMovePoint.add(eatCanMoveTo(1,1));
            }
        }else{
            if(source.getX()==6){
                CanMovePoint.add(canMoveToHelp(-1,0));
                CanMovePoint.add(canMoveToHelp(-2,0));
                CanMovePoint.add(eatCanMoveTo(-1,-1));
                CanMovePoint.add(eatCanMoveTo(-1,1));
            }else{
                CanMovePoint.add(canMoveToHelp(-1,0));
                CanMovePoint.add(eatCanMoveTo(-1,-1));
                CanMovePoint.add(eatCanMoveTo(-1,1));
            }
        }
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
    @Override
    public ChessboardPoint canMoveToHelp(int dx,int dy){
        ChessboardPoint afterMove = source.offset(dx, dy);
        if(afterMove!=null && BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(ChessColor.NONE)){
            return afterMove;//still in board and can't eat so just to empty boardpoint
        }else{
            return null;
        }
    }
    public ChessboardPoint eatCanMoveTo(int dx,int dy){
        ChessboardPoint afterMove = source.offset(dx, dy);
        if(afterMove!=null && !BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(ChessColor.NONE)
        && !BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
            return afterMove;//still in board and eat its opposite(not none and not its teammate)
        }else{
            return null;
        }
    }

}
