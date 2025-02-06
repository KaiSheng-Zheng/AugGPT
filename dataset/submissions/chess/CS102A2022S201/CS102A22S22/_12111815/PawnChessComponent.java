import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        if (isBlack()){
            if (getSource().getX() == 1
                    && Game.getChess(getSource().getX() + 1,getSource().getY()).getChessColor() == ChessColor.NONE
                    && Game.getChess(getSource().getX() + 2,getSource().getY()).getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint( (getSource().getX() + 2) , getSource().getY() ) );
            }
            if (getSource().getX() != 7
                    && Game.getChess(getSource().getX() + 1,getSource().getY()).getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint((getSource().getX() + 1),getSource().getY()));
            }
            if (getSource().getX() != 7 
                    && notOut(getSource(),1,1) 
                    && Game.getChess(getSource().getX() + 1,getSource().getY() + 1).getChessColor() == ChessColor.WHITE){
                list.add(new ChessboardPoint((getSource().getX() + 1),(getSource().getY() + 1)));
            }
            if (getSource().getX() != 7
                    && notOut(getSource(),1,-1)
                    && Game.getChess(getSource().getX() + 1,getSource().getY() - 1).getChessColor() == ChessColor.WHITE){
                list.add(new ChessboardPoint((getSource().getX() + 1),(getSource().getY() - 1)));
            }
        }else {
            if (getSource().getX() == 6
                    && Game.getChess(getSource().getX() - 1,getSource().getY()).getChessColor() == ChessColor.NONE
                    && Game.getChess(getSource().getX() - 2,getSource().getY()).getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint( (getSource().getX() - 2) , getSource().getY() ) );
            }
            if (getSource().getX() != 0
                    && Game.getChess(getSource().getX() - 1,getSource().getY()).getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint((getSource().getX() - 1),getSource().getY()));
            }
            if (getSource().getX() != 0
                    && notOut(getSource(),-1,1)
                    && Game.getChess(getSource().getX() - 1,getSource().getY() + 1).getChessColor() == ChessColor.BLACK){
                list.add(new ChessboardPoint((getSource().getX() - 1),(getSource().getY() + 1)));
            }
            if (getSource().getX() != 0
                    && notOut(getSource(),-1,-1)
                    && Game.getChess(getSource().getX() - 1,getSource().getY() - 1).getChessColor() == ChessColor.BLACK){
                list.add(new ChessboardPoint((getSource().getX() - 1),(getSource().getY() - 1)));
            }
        }
        return list;
    }
}
