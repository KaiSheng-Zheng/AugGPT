import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ret = new ArrayList<>();
        int x = source.getX(), y = source.getY();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if((Math.abs(x-i) == 2 && Math.abs(y-j) == 1) || (Math.abs(x-i) == 1 && Math.abs(y-j) == 2)  && chessComponents[i][j].getChessColor() != super.getChessColor())
                    ret.add(new ChessboardPoint(i,j));
            }
        }

        ret.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) return 1;
                if (o1.getX() == o2.getX()) {
                    if (o1.getY() > o2.getY()) return 1;
                    else return -1;
                } else return -1;
            }
        });

        return ret;
    }
}
