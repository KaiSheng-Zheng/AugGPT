import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK)name='N';
        if (chessColor==ChessColor.WHITE)name='n';
    }
    final int[][] move=new int[][]{{-1,2},{-1-2},{1,2},{1,-2},{2,1},{2,-1},{-2,-1},{-2,1}};

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canmove=new ArrayList<>();//points that can move to
        for(int i=0;i<8;i++){
            ChessboardPoint moveTo=source.offset(move[i][0],move[i][1]);//the points move to
            if(moveTo!=null&&chessboard[moveTo.getX()][moveTo.getY()].chessColor!=chessColor){
                canmove.add(moveTo);
            }
        }
        return canmove;
    }
}
