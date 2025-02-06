import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ret = new ArrayList<>();

        int x = source.getX(), y = source.getY();

        for(int i = x-1; i >= 0; i--) {
            if(chessComponents[i][y] instanceof EmptySlotComponent) ret.add(new ChessboardPoint(i,y));
            else {
                if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
                break;
            }
        }

        for(int i = x+1; i < 8; i++) {
            if(chessComponents[i][y] instanceof EmptySlotComponent) ret.add(new ChessboardPoint(i,y));
            else {
                if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
                break;
            }
        }

        for(int i = y-1; i >= 0; i--) {
            if(chessComponents[x][i] instanceof EmptySlotComponent) ret.add(new ChessboardPoint(x,i));
            else {
                if(chessComponents[x][i].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x,i));
                break;
            }
        }

        for(int i = y+1; i < 8; i++) {
            if(chessComponents[x][i] instanceof EmptySlotComponent) ret.add(new ChessboardPoint(x,i));
            else {
                if(chessComponents[x][i].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(x,i));
                break;
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