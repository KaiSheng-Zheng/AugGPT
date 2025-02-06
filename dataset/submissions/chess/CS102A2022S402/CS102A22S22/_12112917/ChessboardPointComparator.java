import java.util.Comparator;

public class ChessboardPointComparator implements Comparator<ChessboardPoint> {
    public ChessboardPointComparator() {
    }

    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if (o1.getX() < o2.getX()) return -1;
        else if (o1.getX() > o2.getX()) return 1;
        else {
            if (o1.getY() < o2.getY()) return -1;
            else if (o1.getY() > o2.getY()) return 1;
            else return 0;
        }
    }

}

