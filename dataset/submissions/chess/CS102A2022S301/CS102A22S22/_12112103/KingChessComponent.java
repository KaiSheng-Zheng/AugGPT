import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        super();
        setChessColor(chessColor);
        setSource(chessboardPoint);
        if(chessColor==ChessColor.BLACK)name='K';
        if(chessColor==ChessColor.WHITE)name='k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo(){
        int x=this.getSource().getX(),y=this.getSource().getY();
        int[] a={1,1,-1,-1,1,0,-1,0};
        int[] b={1,-1,1,-1,0,1,0,-1};
        List<ChessboardPoint> cMT = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if(onBoard(x+a[i],y+b[i])){

                if(getColor(x+a[i],y+b[i])!=this.getChessColor()){
                    cMT.add(new ChessboardPoint(x+a[i],y+b[i]));
                }
            }
        }
        return cMT;
    }
}
