import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, char name) {
        super.setName(name);
        if ('A'<=name && name<='Z'){
            // The upper case letter indicates black chess pieces,
            // while the lower case letter means white chess pieces.
            super.setChessColor(ChessColor.BLACK);
        }else super.setChessColor(ChessColor.WHITE);
        super.setSource(new ChessboardPoint(x,y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int[][] difference= {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};
        for (int i = 0; i < 8; i++) {
            int dx = difference[i][0];
            int dy = difference[i][1];
            if (new ChessboardPoint(x,y).canMove(dx,dy) &&
                    chessComponents[x+dx][y+dy].getChessColor()!=getChessColor()){
                output.add(new ChessboardPoint(x+dx,y+dy));
            }
        }
        output.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return output;
    }
}
