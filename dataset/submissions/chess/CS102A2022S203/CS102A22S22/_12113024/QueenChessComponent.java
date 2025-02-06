import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
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

        int y2 = source.getY();

        for(int i = x-1; i >= 0; i--) {
            y--; y2++;
            if(y >= 0) {
                if(!(chessComponents[i][y] instanceof EmptySlotComponent)) {
                    if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
                    y = -1;
                }
                else if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
            }

            if(y2 < 8) {
                if(!(chessComponents[i][y2] instanceof EmptySlotComponent)) {
                    if(chessComponents[i][y2].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y2));
                    y2 = 8;
                }
                else if(chessComponents[i][y2].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y2));
            }
        }

        y = source.getY(); y2 = source.getY();

        for(int i = x+1; i < 8; i++) {
            y--; y2++;
            if(y >= 0) {
                if(!(chessComponents[i][y] instanceof EmptySlotComponent)) {
                    if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
                    y = -1;
                }
                else if(chessComponents[i][y].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y));
            }

            if(y2 < 8) {
                if(!(chessComponents[i][y2] instanceof EmptySlotComponent)) {
                    if(chessComponents[i][y2].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y2));
                    y2 = 8;
                }
                else if(chessComponents[i][y2].getChessColor() != super.getChessColor()) ret.add(new ChessboardPoint(i,y2));
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
