import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Q = new ArrayList<>();
        for (int i=1;i<8;i++){
            Q.add(getSource().offset(i,0));
            Q.add(getSource().offset(0,i));
            Q.add(getSource().offset(-i,0));
            Q.add(getSource().offset(0,-i));
            Q.add(getSource().offset(i,i));
            Q.add(getSource().offset(i,-i));
            Q.add(getSource().offset(-i,i));
            Q.add(getSource().offset(-i,-i));
        }
        return Q;
    }
}
