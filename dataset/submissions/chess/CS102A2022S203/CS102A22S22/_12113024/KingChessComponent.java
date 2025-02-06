import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ret = new ArrayList<>();
        int x = source.getX(), y = source.getY();

        if(x-1 >= 0) {
            if(chessComponents[x-1][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x-1,y));
            if(y-1 >= 0  && chessComponents[x-1][y-1].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x-1,y-1));
            if(y+1 < 8 && chessComponents[x-1][y+1].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x-1,y+1));
        }
        if(x+1 < 8) {
            if(chessComponents[x+1][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x+1,y));
            if(y-1 >= 0 && chessComponents[x+1][y-1].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x+1,y-1));
            if(y+1 < 8 && chessComponents[x+1][y+1].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x+1,y+1));
        }
        if(y-1 >= 0 && chessComponents[x][y-1].getChessColor() != super.getChessColor())
            ret.add(new ChessboardPoint(x,y-1));
        if(y+1 < 8 && chessComponents[x][y+1].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x,y+1));

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
