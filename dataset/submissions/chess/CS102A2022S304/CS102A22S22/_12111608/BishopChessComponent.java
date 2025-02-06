import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){}
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        for(int i=1;i<Math.min(x,7-y)+1;i++){if(isInBoard(source,-i,i)){if(!isEmpty(source,-i,i)){if(isDifferentColor(source,-i,i)){canMovePoint.add(source.offset(-i,i));}break;}canMovePoint.add(source.offset(-i,i));}}
        for(int i=1;i<Math.min(x,y)+1;i++){if(isInBoard(source,-i,-i)){if(!isEmpty(source,-i,-i)){if(isDifferentColor(source,-i,-i)){canMovePoint.add(source.offset(-i,-i));}break;}canMovePoint.add(source.offset(-i,-i));}}
        for(int i=1;i<Math.min(7-x,7-y)+1;i++){if(isInBoard(source,i,i)){if(!isEmpty(source,i,i)){if(isDifferentColor(source,i,i)){canMovePoint.add(source.offset(i,i));}break;}canMovePoint.add(source.offset(i,i));}}
        for(int i=1;i<Math.min(7-x,y)+1;i++){if(isInBoard(source,i,-i)){if(!isEmpty(source,i,-i)){if(isDifferentColor(source,i,-i)){canMovePoint.add(source.offset(i,-i));}break;}canMovePoint.add(source.offset(i,-i));}}
        return canMovePoint;
    }
}

