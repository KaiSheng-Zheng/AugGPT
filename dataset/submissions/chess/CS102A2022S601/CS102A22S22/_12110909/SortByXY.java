import java.util.Comparator;

class SortByXY implements Comparator<ChessboardPoint> {
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        if(o1.getX()>o2.getX()) {
            return 1;
        }
        else if (o1.getX() == o2.getX()) {
            if (o1.getY()>o2.getY()){
                return 1;
            }
                else if (o1.getY()==o2.getY()){return 0;}
                return -1;
            }
        return -1;
    }
}

