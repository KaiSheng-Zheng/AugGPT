import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(){}
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){super(source,chessColor);}
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
        for(int i=1;i<x+1;i++){if(isInBoard(source,-i,0)){if(!isEmpty(source,-i,0)){if(isDifferentColor(source,-i,0)){canMovePoint.add(source.offset(-i,0));}break;}canMovePoint.add(source.offset(-i,0));}}
        for(int i=1;i<7-y+1;i++){if(isInBoard(source,0,i)){if(!isEmpty(source,0,i)){if(isDifferentColor(source,0,i)){canMovePoint.add(source.offset(0,i));}break;}canMovePoint.add(source.offset(0,i));}}
        for(int i=1;i<y+1;i++){if(isInBoard(source,0,-i)){if(!isEmpty(source,0,-i)){if(isDifferentColor(source,0,-i)){canMovePoint.add(source.offset(0,-i));}break;}canMovePoint.add(source.offset(0,-i));}}
        for(int i=1;i<7-x+1;i++){if(isInBoard(source,i,0)){if(!isEmpty(source,i,0)){if(isDifferentColor(source,i,0)){canMovePoint.add(source.offset(i,0));}break;}canMovePoint.add(source.offset(i,0));}}
        return canMovePoint;
    }
}

