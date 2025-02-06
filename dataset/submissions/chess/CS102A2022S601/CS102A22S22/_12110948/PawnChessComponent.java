import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if(currentPlayer(getSource()) == ChessColor.BLACK){
            if(getSource().getX() == 1) {
                if (Game.getChess(getSource().getX() + 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() + 1, getSource().getY()).getSource());
                }
                if (Game.getChess(getSource().getX() + 2,getSource().getY()).getChessColor() == ChessColor.NONE
                        && Game.getChess(getSource().getX() + 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() + 2, getSource().getY()).getSource());
                }
            }else {
                if (Game.getChess(getSource().getX() + 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() + 1, getSource().getY()).getSource());
                }
            }
            if(inGraph(getSource(),1,1) && Game.getChess(getSource().getX() + 1,getSource().getY() + 1).getChessColor() == ChessColor.WHITE){
                canMoveTo.add(Game.getChess(getSource().getX() + 1,getSource().getY() + 1).getSource());
            }
            if(inGraph(getSource(),1,-1) && Game.getChess(getSource().getX() + 1,getSource().getY() - 1).getChessColor() == ChessColor.WHITE){
                canMoveTo.add(Game.getChess(getSource().getX() + 1,getSource().getY() - 1).getSource());
            }
        }else {
            if(getSource().getX() == 6) {
                if (Game.getChess(getSource().getX() - 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() - 1, getSource().getY()).getSource());
                }
                if (Game.getChess(getSource().getX() - 2,getSource().getY()).getChessColor() == ChessColor.NONE
                        && Game.getChess(getSource().getX() - 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() - 2, getSource().getY()).getSource());
                }
            }else{
                if (Game.getChess(getSource().getX() - 1,getSource().getY()).getChessColor() == ChessColor.NONE) {
                    canMoveTo.add(Game.getChess(getSource().getX() - 1, getSource().getY()).getSource());
                }
            }
            if(inGraph(getSource(),-1,1) && Game.getChess(getSource().getX() - 1,getSource().getY() + 1).getChessColor() == ChessColor.BLACK){
                canMoveTo.add(Game.getChess(getSource().getX() - 1,getSource().getY() + 1).getSource());
            }
            if(inGraph(getSource(),-1,-1) && Game.getChess(getSource().getX() - 1,getSource().getY() - 1).getChessColor() == ChessColor.BLACK){
                canMoveTo.add(Game.getChess(getSource().getX() - 1,getSource().getY() - 1).getSource());
            }
        }
        return canMoveTo;
    }
}
