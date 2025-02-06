import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    int x,y;

    public PawnChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        if(color==ChessColor.BLACK){name='P';}else{name='p';}
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmoveto=new ArrayList<>();
        x=getSource().getX();y=getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i==x&&j==y){continue;}
                if(chessComponents[i][j].getChessColor()==getChessColor()){continue;}
                boolean k=false;
                if(getChessColor()==ChessColor.BLACK){
                    if(chessComponents[i][j].getChessColor()==ChessColor.NONE&&x==1&&i==3&&y==j){k=true;}
                    else if(chessComponents[i][j].getChessColor()==ChessColor.NONE&&x-i==-1&&y==j){k=true;}
                    else if(Math.abs(y-j)==1&&x-i==-1&&chessComponents[i][j].getChessColor()==ChessColor.WHITE){k=true;}
                }
                else {
                    if(chessComponents[i][j].getChessColor()==ChessColor.NONE&&x==6&&i==4&&y==j){k=true;}
                    else if(chessComponents[i][j].getChessColor()==ChessColor.NONE&&x-i==1&&y==j){k=true;}
                    else if(Math.abs(y-j)==1&&x-i==1&&chessComponents[i][j].getChessColor()==ChessColor.BLACK){k=true;}
                }

                if(k) canmoveto.add(chessComponents[i][j].getSource());
            }
        }
         return canmoveto;
    }
}
