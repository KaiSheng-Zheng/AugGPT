import java.util.ArrayList;
import java.util.List;

public class Empty extends ChessComponent {
    Empty(){
        name='_';
        super.setChessColor(ChessColor.NONE);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        return new ArrayList<>();
    }
}
