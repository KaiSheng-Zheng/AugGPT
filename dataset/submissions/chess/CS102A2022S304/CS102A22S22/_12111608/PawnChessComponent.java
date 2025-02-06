import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent() {}
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        if(this.getChessColor()==ChessColor.BLACK){
            if(x==1){
                if(isInBoard(source,1,0)){if(isEmpty(source,1,0)){canMovePoint.add(source.offset(1,0));}}
                if(isInBoard(source,2,0)){if(isEmpty(source,2,0)&&isEmpty(source,1,0)){canMovePoint.add(source.offset(2,0));}}
            }else{if(isInBoard(source,1,0)){if(isEmpty(source,1,0)){canMovePoint.add(source.offset(1,0));}}}
            if(isInBoard(source,1,-1)){if(isDifferentColor(source,1,-1)){canMovePoint.add(source.offset(1,-1));}}
            if(isInBoard(source,1,1)){if(isDifferentColor(source,1,1)){canMovePoint.add(source.offset(1,1));}}
            return canMovePoint;
        }else{
            if(x==6){
                if(isInBoard(source,-1,0)){if(isEmpty(source,-1,0)){canMovePoint.add(source.offset(-1,0));}}
                if(isInBoard(source,-2,0)){if(isEmpty(source,-2,0)&&isEmpty(source,-1,0)){canMovePoint.add(source.offset(-2,0));}}
            }else{if(isInBoard(source,-1,0)){if(isEmpty(source,-1,0)){canMovePoint.add(source.offset(-1,0));}}}
            if(isInBoard(source,-1,-1)){if(isDifferentColor(source,-1,-1)){canMovePoint.add(source.offset(-1,-1));}}
            if(isInBoard(source,-1,1)){if(isDifferentColor(source,-1,1)){canMovePoint.add(source.offset(-1,1));}}
            return canMovePoint;
        }
    }

}
