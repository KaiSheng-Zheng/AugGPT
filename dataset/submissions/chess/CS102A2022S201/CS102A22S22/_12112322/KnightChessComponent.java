import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> N = new ArrayList<>();
        for (int i=1;i<8;i++){
            N.add(getSource().offset(i,i));
            N.add(getSource().offset(i,-i));
            N.add(getSource().offset(-i,i));
            N.add(getSource().offset(-i,-i));
        }
        return N;
    }
}
