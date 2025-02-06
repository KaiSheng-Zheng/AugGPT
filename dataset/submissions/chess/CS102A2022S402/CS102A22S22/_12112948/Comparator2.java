import java.util.Comparator;

public class Comparator2 implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        return o1.getY()-o2.getY();
    }
}
