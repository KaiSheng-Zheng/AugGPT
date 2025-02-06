import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    int x,y;

    public RookChessComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        if(color==ChessColor.BLACK){name='R';}else{name='r';}
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
                if(x==i){
                    k=true;
                    int col=y-j;
                    if(col>1){
                        for (int l = 1; l < col; l++) {
                            if(chessComponents[i][j+l].getChessColor()!=ChessColor.NONE){k=false;break;}
                        }
                    }
                    if(col<-1){
                        for (int l = 1; l < -col; l++) {
                            if(chessComponents[i][j-l].getChessColor()!=ChessColor.NONE){k=false;break;}
                        }
                    }
                }
                else if(chessComponents[i][j].getChessColor()!=getChessColor()&&y==j){
                    k=true;
                    int row=x-i;
                    if(row>1){
                        for (int l = 1; l < row; l++) {
                            if(chessComponents[i+l][j].getChessColor()!=ChessColor.NONE){k=false;break;}
                        }
                    }
                    if(row<-1){
                        for (int l = 1; l < -row; l++) {
                            if(chessComponents[i-l][j].getChessColor()!=ChessColor.NONE){k=false;break;}
                        }
                    }
                }

                if(k) canmoveto.add(chessComponents[i][j].getSource());
            }
        }
         return canmoveto;
    }
}
