import java.util.Comparator;

public class Comparator1 implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        return o1.getX()-o2.getX();
    }
}
