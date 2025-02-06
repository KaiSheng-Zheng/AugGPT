import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char k) {
    }

    private static boolean sameDiagonal(ChessboardPoint a, ChessboardPoint b){
        return Math.abs(a.getX()) - b.getX() == Math.abs(a.getY() - b.getY());
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        if (!(Math.abs(source.getX()-destination.getX())+Math.abs(source.getY()-destination.getY())==1)&&!(Math.abs(source.getX()-destination.getX())==1&&sameDiagonal(source,destination))){
            return new ArrayList<>();
        }else return Collections.singletonList(destination);

    }
}