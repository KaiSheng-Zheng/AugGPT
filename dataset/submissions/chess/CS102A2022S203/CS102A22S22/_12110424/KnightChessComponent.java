import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, ChessColor a, char name) {
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(a);
        super.setName(name);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int[]knight = {-2,-1,1,2};
        for (int x :knight){
            for (int y :knight){
                if (Math.abs(x)!=Math.abs(y)&&super.getSource().getX()+x>=0&&super.getSource().getX()+x<8&&
                        super.getSource().getY()+y>=0&&super.getSource().getY()+y<8&&
                        super.getComponents()[super.getSource().getX()+x][super.getSource().getY()+y].getChessColor()!=super.getChessColor()){
                    canMoveTo.add(new ChessboardPoint(super.getSource().getX()+x,super.getSource().getY()+y));
                }
            }
        }
        return canMoveTo;
    }
}
