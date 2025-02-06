import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> R = new ArrayList<>();
        for (int i=1;i<8;i++){
            R.add(getSource().offset(i,0));
            R.add(getSource().offset(0,i));
            R.add(getSource().offset(-i,0));
            R.add(getSource().offset(0,-i));
        }
        return R;
    }
}
