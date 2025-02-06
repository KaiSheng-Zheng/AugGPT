import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x,int y,char name) {
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
        int[][] basis = {{-1,1},{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,-1},{1,1}};
        for (int i = 0; i < basis.length; i++) {
            output.addAll(moveAndEat(x,y,basis[i][0],basis[i][1]));
        }
        output.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return output;
    }

}
