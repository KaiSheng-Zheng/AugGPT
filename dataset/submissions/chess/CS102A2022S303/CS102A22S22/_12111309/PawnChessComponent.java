import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    protected char name='_';

    public PawnChessComponent(ChessboardPoint c,ChessColor b,char a) {
        source = c;
        super.setChessColor(b);
        name = a;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();

        return points;
    }
    @Override
    public char getName() {
        return name;
    }
}
