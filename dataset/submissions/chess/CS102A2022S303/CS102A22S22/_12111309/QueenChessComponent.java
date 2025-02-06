import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source;

    public QueenChessComponent(ChessboardPoint c,ChessColor b,char a) {
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

