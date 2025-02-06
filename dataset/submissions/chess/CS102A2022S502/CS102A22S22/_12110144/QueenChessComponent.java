import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    int x,y;

    public QueenChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        if(color==ChessColor.BLACK){name='Q';}else{name='q';}
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto=new ArrayList<>();
        x=getSource().getX();y=getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==x&&j==y){continue;}
                boolean k=false;
                if(chessComponents[i][j].getChessColor()!=getChessColor()&&Math.abs(x-i)==Math.abs(y-j)){
                    k=true;
                    int row=x-i,col=y-j;
                    if(Math.abs(row)>1) for (int l = 1; l < Math.abs(row); l++) {
                        int xx=l*(row)/(Math.abs(row)),yy=l*(col)/(Math.abs(col));
                        if(!(chessComponents[i+xx][j+yy] instanceof EmptySlotComponent)){k=false;break;}
                    }
                }
                else if(chessComponents[i][j].getChessColor()!=getChessColor()&&x==i){
                    k=true;
                    int col=y-j;
                    if(Math.abs(col)>1) for (int l = 1; l < Math.abs(col); l++) {
                        int yy=l*(col)/(Math.abs(col));
                        if(!(chessComponents[i][j+yy] instanceof EmptySlotComponent)){k=false;break;}
                    }
                }
                else if(chessComponents[i][j].getChessColor()!=getChessColor()&&y==j){
                    k=true;
                    int row=x-i;
                    if(Math.abs(row)>1) for (int l = 1; l < Math.abs(row); l++) {
                        int xx=l*(row)/(Math.abs(row));
                        if(!(chessComponents[i+xx][j] instanceof EmptySlotComponent)){k=false;break;}
                    }
                }

                if(k) canmoveto.add(chessComponents[i][j].getSource());
            }
        }
         return canmoveto;
    }
}
