import java.util.ArrayList;
import java.util.List;

public class BishopChessCompoent extends ChessComponent {


    public BishopChessCompoent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BishopsLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        int A;
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (Math.abs(X - i) == Math.abs((Y - j))){
                    BishopsLand.add(new ChessboardPoint(i,j));
                }
            }
        }
        return BishopsLand;
    }
}