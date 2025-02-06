import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (inGraph(getSource(),1,2) && notSelf(getSource(),getSource().getX() + 1,getSource().getY() + 2)){
            canMoveTo.add(Game.getChess(getSource().getX() + 1,getSource().getY() + 2).getSource());
        }
        if (inGraph(getSource(),-1,2) && notSelf(getSource(),getSource().getX() - 1,getSource().getY() + 2)){
            canMoveTo.add(Game.getChess(getSource().getX() - 1,getSource().getY() + 2).getSource());
        }
        if (inGraph(getSource(),1,-2) && notSelf(getSource(),getSource().getX() + 1,getSource().getY() - 2)){
            canMoveTo.add(Game.getChess(getSource().getX() + 1,getSource().getY() - 2).getSource());
        }
        if (inGraph(getSource(),-1,-2) && notSelf(getSource(),getSource().getX() - 1,getSource().getY() - 2)){
            canMoveTo.add(Game.getChess(getSource().getX() - 1,getSource().getY() - 2).getSource());
        }
        if (inGraph(getSource(),2,1) && notSelf(getSource(),getSource().getX() + 2,getSource().getY() + 1)){
            canMoveTo.add(Game.getChess(getSource().getX() + 2,getSource().getY() + 1).getSource());
        }
        if (inGraph(getSource(),-2,1) && notSelf(getSource(),getSource().getX() - 2,getSource().getY() + 1)){
            canMoveTo.add(Game.getChess(getSource().getX() - 2,getSource().getY() + 1).getSource());
        }
        if (inGraph(getSource(),2,-1) && notSelf(getSource(),getSource().getX() + 2,getSource().getY() - 1)){
            canMoveTo.add(Game.getChess(getSource().getX() + 2,getSource().getY() - 1).getSource());
        }
        if (inGraph(getSource(),-2,-1) && notSelf(getSource(),getSource().getX() - 2,getSource().getY() - 1)){
            canMoveTo.add(Game.getChess(getSource().getX() - 2,getSource().getY() - 1).getSource());
        }
        return canMoveTo;
    }
}
