import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    int x,y;

    public KingChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        if(color==ChessColor.BLACK){name='K';}else{name='k';}
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto=new ArrayList<>();
        x=getSource().getX();y=getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==x&&j==y){continue;}
                boolean k=false;
                if(chessComponents[i][j].getChessColor()!=getChessColor()&&Math.abs(x-i)<=1&&Math.abs(y-j)<=1){k=true;}
                if(k) canmoveto.add(chessComponents[i][j].getSource());
            }
        }
         return canmoveto;
    }
}