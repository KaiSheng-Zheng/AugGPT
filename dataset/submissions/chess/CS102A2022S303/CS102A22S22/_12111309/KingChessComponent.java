import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;

    public KingChessComponent(ChessboardPoint c,ChessColor b,char a) {
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
