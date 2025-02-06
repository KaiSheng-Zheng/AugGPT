import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor==ChessColor.BLACK)name='P';
        if (chessColor==ChessColor.WHITE)name='p';
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canmove=new ArrayList<>();//points that can move to
        int x=source.getX();
        int y=source.getY();
        if(chessColor==ChessColor.BLACK){
            if(source.offset(1,0)!=null&&chessboard[x+1][y].chessColor==ChessColor.NONE){//
                canmove.add(source.offset(1,0));
                if(x==1&&source.offset(2,0)!=null&&chessboard[x+2][y].chessColor==ChessColor.NONE){
                    canmove.add(source.offset(2,0));
                }
            }
            if(source.offset(1,1)!=null&&chessboard[x+1][y+1].chessColor==ChessColor.WHITE){
                canmove.add(source.offset(1,1));//
            }
            if(source.offset(1,-1)!=null&&chessboard[x+1][y-1].chessColor==ChessColor.WHITE){
                canmove.add(source.offset(1,-1));//
            }
        }
        else{
            if(source.offset(-1,0)!=null&&chessboard[x-1][y].chessColor==ChessColor.NONE){//
                canmove.add(source.offset(-1,0));
                if(x==6&&source.offset(-2,0)!=null&&chessboard[x-2][y].chessColor==ChessColor.NONE){
                    canmove.add(source.offset(-2,0));
                }
            }
            if(source.offset(-1,1)!=null&&chessboard[x-1][y+1].chessColor==ChessColor.BLACK){
                canmove.add(source.offset(-1,1));//
            }
            if(source.offset(-1,-1)!=null&&chessboard[x-1][y-1].chessColor==ChessColor.BLACK){
                canmove.add(source.offset(-1,-1));//
            }
        }
        return canmove;
    }
}
