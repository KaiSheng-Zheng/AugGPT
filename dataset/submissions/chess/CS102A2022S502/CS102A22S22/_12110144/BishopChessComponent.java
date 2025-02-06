import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    int x,y;
    ChessColor chessColor;
    public BishopChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        this.chessColor=color;
        if(color==ChessColor.BLACK){name='B';}else{name='b';}

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto=new ArrayList<>();
        x=getSource().getX();y=getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==x&&j==y){continue;}
                boolean k=false;
                if(!chessComponents[i][j].getChessColor().equals(chessColor)&&Math.abs(x-i)==Math.abs(y-j)){
                    k=true;
                    int row=x-i,col=y-j;
                    if(Math.abs(row)>1) for (int l = 1; l < Math.abs(row); l++) {
                        int xx=l*(row)/(Math.abs(row)),yy=l*(col)/(Math.abs(col));
                        if(!(chessComponents[i+xx][j+yy].toString().equals("_"))){k=false;break;}
                    }
                }
                if(k) {canmoveto.add(chessComponents[i][j].getSource());}
            }
        }
         return canmoveto;
    }
}
