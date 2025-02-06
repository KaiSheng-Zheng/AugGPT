import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint point= getSource();
        int[][] directions={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,-1},{1,1}};
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
