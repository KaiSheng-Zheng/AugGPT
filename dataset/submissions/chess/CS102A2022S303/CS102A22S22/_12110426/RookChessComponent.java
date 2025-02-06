import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        if (getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }else if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { 
            return false;
        }
        return true;
    }
}