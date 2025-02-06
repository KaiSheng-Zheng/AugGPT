import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        if (getChessColor()!=chessComponents[destination.getX()][destination.getY()].getChessColor()){
         if (destination.getX()-source.getX() ==destination.getY()-source.getY()) {
             int row =Math.min(source.getX(),destination.getX());int col =Math.min(source.getY(),destination.getY())+1;
             for (int i = row+1; i <Math.max(source.getX(),destination.getX()) ; i++) {
                 if (!(chessComponents[i][col] instanceof EmptySlotComponent)){
                     return false;
                 }
                 col++;
             }
            return true;
        }
        else if (destination.getX()-source.getX() ==source.getY()-destination.getY()) {
             int row =Math.min(source.getX(),destination.getX());int col =Math.max(source.getY(),destination.getY())-1;
             for (int i = row+1; i <Math.max(source.getX(),destination.getX()) ; i++) {
                 if (!(chessComponents[i][col] instanceof EmptySlotComponent)){
                     return false;
                 }
                 col--;
             }
            return true;
        }
    }
        return false;

    }
}