import java.util.ArrayList;
import java.util.List;

public class EmptyChessComponent extends ChessComponent {
    public EmptyChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        super(chessboardPoint,chessComponents,name);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points=new ArrayList<>();
        return points;
    }
}
