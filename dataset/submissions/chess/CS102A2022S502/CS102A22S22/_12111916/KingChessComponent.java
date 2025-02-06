import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public boolean ss(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        int a=Math.abs(source.getX()-destination.getX()); int b=Math.abs(source.getY()-destination.getY());
        if((a==1&&b==1)||(a==1&&b==0)||(a==0&&b==1)){
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
