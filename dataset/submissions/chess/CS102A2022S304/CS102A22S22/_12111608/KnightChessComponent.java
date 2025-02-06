import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent() {}
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        if(isInBoard(source,-2,-1)){if(isEmpty(source,-2,-1)||isDifferentColor(source,-2,-1)){canMovePoint.add(source.offset(-2,-1));}}
        if(isInBoard(source,-2,1)){if(isEmpty(source,-2,1)||isDifferentColor(source,-2,1)){canMovePoint.add(source.offset(-2,1));}}
        if(isInBoard(source,-1,-2)){if(isEmpty(source,-1,-2)||isDifferentColor(source,-1,-2)){canMovePoint.add(source.offset(-1,-2));}}
        if(isInBoard(source,-1,2)){if(isEmpty(source,-1,2)||isDifferentColor(source,-1,2)){canMovePoint.add(source.offset(-1,2));}}
        if(isInBoard(source,1,-2)){if(isEmpty(source,1,-2)||isDifferentColor(source,1,-2)){canMovePoint.add(source.offset(1,-2));}}
        if(isInBoard(source,1,2)){if(isEmpty(source,1,2)||isDifferentColor(source,1,2)){canMovePoint.add(source.offset(1,2));}}
        if(isInBoard(source,2,-1)){if(isEmpty(source,2,-1)||isDifferentColor(source,2,-1)){canMovePoint.add(source.offset(2,-1));}}
        if(isInBoard(source,2,1)){if(isEmpty(source,2,1)||isDifferentColor(source,2,1)){canMovePoint.add(source.offset(2,1));}}
        return canMovePoint;
    }
}
