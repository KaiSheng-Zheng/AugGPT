import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends  ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK)name='R';
        if (chessColor==ChessColor.WHITE)name='r';
    }

    final int[][] move=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canmove=new ArrayList<>();//points that can move to
        for(int i=0;i<4;i++){
            for(int j=1;j<=7;j++){
                ChessboardPoint moveTo=source.offset(move[i][0]*j,move[i][1]*j);//the points move to
                if(moveTo!=null&&chessboard[moveTo.getX()][moveTo.getY()].chessColor==ChessColor.NONE){
                    canmove.add(moveTo);
                }
                else if(moveTo!=null&&chessboard[moveTo.getX()][moveTo.getY()].chessColor!=chessColor){
                    canmove.add(moveTo);
                    break;
                }
                else break;
            }
        }
        return canmove;
    }
}
