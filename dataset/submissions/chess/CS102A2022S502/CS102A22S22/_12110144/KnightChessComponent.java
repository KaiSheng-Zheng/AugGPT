import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    int x,y;

    public KnightChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        if(color==ChessColor.BLACK){super.name='N';}else{super.name='n';}
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto=new ArrayList<>();
        x=getSource().getX();y=getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==x&&j==y){continue;}
                if(chessComponents[i][j].getChessColor().equals(getChessColor())){continue;}
                boolean k=false;
                int row=Math.abs(i-x);
                int col=Math.abs(j-y);
                if(row*col==2){k=true;}
                if(k) canmoveto.add(chessComponents[i][j].getSource());
            }
        }
         return canmoveto;
    }
}
