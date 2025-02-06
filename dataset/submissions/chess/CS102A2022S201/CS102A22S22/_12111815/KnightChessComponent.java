import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int a = 1;
        int b = 2;
        if (notOut(getSource(),a,b)
                && getChessColor() != Game.getChess(getSource().getX() + a,getSource().getY() + b).getChessColor()){
                list.add(Game.getChess(getSource().getX() + a,getSource().getY() + b).getSource());
        }
        if (notOut(getSource(),-a,b)
                && getChessColor() != Game.getChess(getSource().getX() - a,getSource().getY() + b).getChessColor()){
            list.add(Game.getChess(getSource().getX() - a,getSource().getY() + b).getSource());
        }
        if (notOut(getSource(),a,-b)
                && getChessColor() != Game.getChess(getSource().getX() + a,getSource().getY() - b).getChessColor()){
            list.add(Game.getChess(getSource().getX() + a,getSource().getY() - b).getSource());
        }if (notOut(getSource(),-a,-b)
                && getChessColor() != Game.getChess(getSource().getX() - a,getSource().getY() - b).getChessColor()){
            list.add(Game.getChess(getSource().getX() - a,getSource().getY() - b).getSource());
        }
        if (notOut(getSource(),b,a)
                && getChessColor() != Game.getChess(getSource().getX() + b,getSource().getY() + a).getChessColor()){
            list.add(Game.getChess(getSource().getX() + b,getSource().getY() + a).getSource());
        }
        if (notOut(getSource(),-b,a)
                && getChessColor() != Game.getChess(getSource().getX() - b,getSource().getY() + a).getChessColor()){
            list.add(Game.getChess(getSource().getX() - b,getSource().getY() + a).getSource());
        }if (notOut(getSource(),b,-a)
                && getChessColor() != Game.getChess(getSource().getX() + b,getSource().getY() - a).getChessColor()){
            list.add(Game.getChess(getSource().getX() + b,getSource().getY() - a).getSource());
        }
        if (notOut(getSource(),-b,-a)
                && getChessColor() != Game.getChess(getSource().getX() - b,getSource().getY() - a).getChessColor()){
            list.add(Game.getChess(getSource().getX() - b,getSource().getY() - a).getSource());
        }
        return list;
    }
}
