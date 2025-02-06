import java.util.ArrayList;
import java.util.List;

public class EmptyChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
//        System.out.println("Empty can Move to");
        List<ChessboardPoint> a=new ArrayList<>();
        return a;
    }
}
