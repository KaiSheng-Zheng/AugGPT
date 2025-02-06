import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  list= new ArrayList<>();
        for (int i = 0; i < getChessComponents().length; i++) {
            for (int j = 0; j < getChessComponents()[i].length; j++) {
                if (MoveTo(getChessComponents(),getChessComponents()[i][j].getSource())&&getChessColor()!=getChessComponents()[i][j].getChessColor()){
                    list.add(getChessComponents()[i][j].getSource());
                }
            }
        }
        return list;
    }


    public boolean MoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
         ChessboardPoint source = getSource();
        if (getChessColor()!=chessComponents[destination.getX()][destination.getY()].getChessColor()) {
        if(Math.abs(source.getX()-destination.getX())==2&&Math.abs(source.getY()-destination.getY())==1){
            return true;}
        else return Math.abs(source.getX() - destination.getX()) == 1 && Math.abs(source.getY() - destination.getY()) == 2;
    }
    return false;}
}
