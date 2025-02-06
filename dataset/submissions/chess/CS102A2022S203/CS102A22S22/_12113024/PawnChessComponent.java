import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    private int theFirstStep;

    public int getTheFirstStep() {
        return theFirstStep;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ret = new ArrayList<>();

        int x = source.getX(), y = source.getY();

        if(super.getChessColor() == ChessColor.WHITE) {
            if(theFirstStep == 0 && chessComponents[x-2][y].getChessColor() != super.getChessColor()) {
                ret.add(new ChessboardPoint(x-2,y));
                theFirstStep = 1;
            }
            if(x-1 >= 0 && chessComponents[x-1][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x-1,y));
        }

        else {
            if(theFirstStep == 0 && chessComponents[x+2][y].getChessColor() != super.getChessColor()) {
                ret.add(new ChessboardPoint(x+2,y));
                theFirstStep = 1;
            }
            if(x+1 < 8 && chessComponents[x+1][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x+1,y));
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
