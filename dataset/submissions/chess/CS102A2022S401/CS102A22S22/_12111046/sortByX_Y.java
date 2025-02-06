import java.util.Comparator;

public class sortByX_Y implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if(o1.getX()>o2.getX()) {
            return 1;
        }
        if(o1.getX()==o2.getX()&&o1.getY()>o2.getY())
            return 1;
        return -1;
    }
}
