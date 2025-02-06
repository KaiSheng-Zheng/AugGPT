import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int[][] directions={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,-1},{1,1}};
        List<ChessboardPoint> move=new ArrayList<>();
        for(int i=0;i<8;i++){
            ChessboardPoint point= getSource();
            int[] a =directions[i];
            while (true){
                ChessboardPoint newp=point.offset(a[0],a[1]);
                if(newp==null){
                    break;
                }
                if(chessboard[newp.getX()][newp.getY()].getChessColor()==getChessColor()){
                    break;
                }
                if(chessboard[newp.getX()][newp.getY()].getChessColor()==ChessColor.NONE){
                    move.add(newp);
                    point=newp;
                }
                else{
                    move.add(newp);
                    break;
                }



            }
        }
        return move;
    }
}
