import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super();
        setChessColor(chessColor);
        setSource(chessboardPoint);
        if(chessColor==ChessColor.BLACK)name='N';
        if(chessColor==ChessColor.WHITE)name='n';
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> cMT=new ArrayList<>();
        int x=getSource().getX(),y=getSource().getY();
        int[] a={2,2,-2,-2,1,1,-1,-1};
        int[] b={1,-1,1,-1,2,-2,2,-2};
        for (int i = 0; i < 8; i++) {
            if(onBoard(x+a[i],y+b[i])){
                if(chessboard[x+a[i]][y+b[i]] instanceof EmptySlotComponent/*.getChessColor()!=getChessColor()*/){
                    cMT.add(new ChessboardPoint(x+a[i],y+b[i]));
                }
            }
        }
        return cMT;
    }
}
