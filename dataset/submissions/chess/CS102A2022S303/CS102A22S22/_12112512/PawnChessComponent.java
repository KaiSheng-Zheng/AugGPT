import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> P = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                if(canMoveTo1(getChessComponents(),new ChessboardPoint(i,k))){
                    P.add(new ChessboardPoint(i,k));

                }
            }
        }
        return P;
    }
    public boolean canMoveTo1(ChessComponent[][] chessComponents, ChessboardPoint destination) {
            ChessboardPoint source = getChessboardPoint();
            if (chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK && destination.getX() - source.getX() == 1 && destination.getY() == source.getY() && (chessComponents[source.getX()+1][destination.getY()].getChessColor() == ChessColor.NONE)) {
                return true;
            } if(source.getX()==1&&chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK && destination.getX() - source.getX() == 2 && destination.getY() == source.getY() && source.getX()==1 && (chessComponents[source.getX()+2][destination.getY()].getChessColor() == ChessColor.NONE)&& (chessComponents[source.getX()+1][destination.getY()].getChessColor() == ChessColor.NONE)) {
                return true;
            } if( chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE && destination.getX() - source.getX() == -1 && destination.getY() == source.getY() && (chessComponents[source.getX()-1][destination.getY()].getChessColor() == ChessColor.NONE)){
                return true;
            } if(source.getX()==6&&chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE && destination.getX() - source.getX() == -2 && destination.getY() == source.getY() && (chessComponents[source.getX()-2][destination.getY()].getChessColor() == ChessColor.NONE)&& (chessComponents[source.getX()-1][destination.getY()].getChessColor() == ChessColor.NONE)) {
                return true;
            }if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK && destination.getX() - source.getX() == 1 && Math.abs(destination.getY() - source.getY())==1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE){
                return true;
            }if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE && destination.getX() - source.getX() == -1 && Math.abs(destination.getY() - source.getY())==1 && chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK){
                return true;
            } if(chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }

            return false;
        }

    

    public PawnChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
    }
}