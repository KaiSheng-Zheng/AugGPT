import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint point= getSource();
        int[][] directions={{-2,-1},{-1,-2},{-1,2},{2,-1},{2,1},{1,2},{1,-2},{-2,1}};
        List<ChessboardPoint> move=new ArrayList<>();
        for(int i=0;i<8;i++){
            int[] a =directions[i];
            ChessboardPoint newp=point.offset(a[0],a[1]);
            if(newp!=null&&chessboard[newp.getX()][newp.getY()].getChessColor() != getChessColor()){
                move.add(newp);}
        }
        return move;
    }
}