import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name,ChessboardPoint point,ChessColor color){
       super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList steps = new ArrayList<>();
        
         return rook1(steps);
    }
}
