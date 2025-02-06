import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public boolean ss(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        destination =new ChessboardPoint(destination.getX(),destination.getY());
        int r1=Math.min(source.getX(), destination.getX());
        int r2=Math.max(source.getX(), destination.getX());
        int c1=Math.min(source.getY(), destination.getY());
        int c2=Math.max(source.getY(), destination.getY());
        int a=source.getX()-destination.getX();  int b=source.getY()-destination.getY();
        if(Math.abs(a)==Math.abs(b) &&a*b>0){
            for(int i=r1+1;i<r2;i++) {
                for(int j=c1+1;j<c2;j++) {
                    int m=i-source.getX(); int n=j-source.getY();
                    if ((!(chessComponents[i][j] instanceof EmptySlotComponent) && ((double)m/n)==1 )) {
                        return false;
                    }

                }
            }
            return true;
        }else if(Math.abs(a)==Math.abs(b) &&a*b<0){
            for(int i=r1+1;i<r2;i++) {
                for(int j=c2-1;j>c1;j--) {
                    int m=i-source.getX(); int n=j-source.getY();
                    if (!(chessComponents[i][j] instanceof EmptySlotComponent) && ((double)m/n)==-1 ) {
                        return false;
                    }

                }
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        ChessboardPoint chessboardPoint;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                ChessComponent[][] chessComponents = getChessboard();
                if(ss(chessComponents, destination)){
                    chess.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chess;
    }
}
