import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {}
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        List<ChessboardPoint> canMovePoint =new ArrayList<>();
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(isInBoard(source,i,j)){if(isEmpty(source,i,j)||isDifferentColor(source,i,j)){canMovePoint.add(source.offset(i,j));}}
            }
        }
        return canMovePoint;
    }
}
