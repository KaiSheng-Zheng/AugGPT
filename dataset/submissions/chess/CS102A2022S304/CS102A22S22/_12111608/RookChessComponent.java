import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent() {}
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        for(int i=1;i<x+1;i++){if(isInBoard(source,-i,0)){if(!isEmpty(source,-i,0)){if(isDifferentColor(source,-i,0)){canMovePoint.add(source.offset(-i,0));}break;}canMovePoint.add(source.offset(-i,0));}}
        for(int i=1;i<7-y+1;i++){if(isInBoard(source,0,i)){if(!isEmpty(source,0,i)){if(isDifferentColor(source,0,i)){canMovePoint.add(source.offset(0,i));}break;}canMovePoint.add(source.offset(0,i));}}
        for(int i=1;i<y+1;i++){if(isInBoard(source,0,-i)){if(!isEmpty(source,0,-i)){if(isDifferentColor(source,0,-i)){canMovePoint.add(source.offset(0,-i));}break;}canMovePoint.add(source.offset(0,-i));}}
        for(int i=1;i<7-x+1;i++){if(isInBoard(source,i,0)){if(!isEmpty(source,i,0)){if(isDifferentColor(source,i,0)){canMovePoint.add(source.offset(i,0));}break;}canMovePoint.add(source.offset(i,0));}}
        return canMovePoint;
    }
}



