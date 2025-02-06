import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public boolean ss(ChessComponent[][] chessComponents, ChessboardPoint destination) {

        ChessboardPoint source = new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
   destination =new ChessboardPoint(destination.getX(),destination.getY());
        if((Math.abs(source.getX()-destination.getX())==2 &&Math.abs(source.getY()-destination.getY())==1)||
                (Math.abs(source.getY()-destination.getY())==2 &&Math.abs(source.getX()-destination.getX())==1)){

            if (!(chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return true;
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
                ChessComponent[][] chessComponents = new ChessComponent[8][8];
                if(ss(chessComponents, destination)){
                    chess.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chess;
    }

    }

