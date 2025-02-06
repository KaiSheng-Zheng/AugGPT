import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public boolean ss(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source =new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        int r1=Math.min(source.getX(), destination.getX());
        int r2=Math.max(source.getX(), destination.getX());
        int c1=Math.min(source.getY(), destination.getY());
        int c2=Math.max(source.getY(), destination.getY());
        int a=source.getX()-destination.getX();  int b=source.getY()-destination.getY();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if(Math.abs(a)==Math.abs(b) &&a*b>0){
            for(int i=r1+1;i<r2;i++) {
                for(int j=c1+1;j<c2;j++) {
                    int m=i-source.getX(); int n=j-source.getY();
                    if ((!(chessboard[i][j] instanceof EmptySlotComponent) && ((double)m/n)==1 )) {
                        return false;
                    }

                }
            }
            return true;
        }else if(Math.abs(a)==Math.abs(b) &&a*b<0){
            for(int i=r1+1;i<r2;i++) {
                for(int j=c2-1;j>c1;j--) {
                    int m=i-source.getX(); int n=j-source.getY();
                    if ((!(chessboard[i][j] instanceof EmptySlotComponent) && ((double)m/n)==-1 )) {
                        return false;
                    }

                }
            }
            return true;
        }else {
            return false;
        }
        return true;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        ChessboardPoint chessboardPoint;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                ChessComponent[][] chessComponents = getChessboard();
                //  ChessComponent[][] chessComponents = new ChessComponent[8][8];
                if(ss(chessComponents, destination)){
                    chess.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chess;
    }
}
