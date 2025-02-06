import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        for(int i = 0;i < 8;i++){
            for (int j = 0;j <8;j++){
                ChessboardPoint c = Game.getChess(i,j).getSource();
                if(getSource().getY() == c.getY() 
                        && canVertical(getSource(),Game.getChess(i,j).getSource()) 
                        && noChess(getSource(),c) 
                        && notSelf(getSource(),i,j)){
                    canMoveTo.add(c);
                } else if((getSource().getX() == c.getX() 
                        && canCross(getSource(),Game.getChess(i,j).getSource())
                        && noChess(getSource(),c)) 
                        && notSelf(getSource(),i,j)){
                    canMoveTo.add(c);
                }
            }
        }
        return canMoveTo;
    }
}
