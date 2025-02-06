import java.util.Comparator;

public class PriSort implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint c1, ChessboardPoint c2) {
        if (c1.getX() > c2.getX()) {
            return 1;
        } else if (c1.getX() == c2.getX()) {
            if (c1.getY() > c2.getY())
                return 1;
            else return -1;
        } else return -1;

    }
}
