import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((canMoveTo(this.getChessboardPoint(),new ChessboardPoint(i,j)))
                        &&(this.getChessColor()!=chessComponents[i][j].getChessColor())){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }
    public boolean canMoveTo(ChessboardPoint source, ChessboardPoint destination) {
        ChessColor a = this.getChessColor();
        int x=destination.getX()-source.getX();
        int y=destination.getY()-source.getY();
        if (a==ChessColor.BLACK){
            if (source.getX() +2 == destination.getX()&&source.getY() == destination.getY()&&source.getX()==1) {
                int row = destination.getX();int col = source.getY();
                if (!(chessComponents[row-1][col] instanceof EmptySlotComponent)||!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                } else {return true;}
            }
            else // Not on the same row or the same column.
                if (source.getX() +1 == destination.getX()&&source.getY() == destination.getY()) {
                    int row = destination.getX();int col = source.getY();
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    } else {return true;}
                }
                else if (x == 1 && (y == -1 || y == 1) && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                    return true;
                }
        }
        else{
            if (source.getX() -2 == destination.getX()&&source.getY() == destination.getY()&&source.getX()==6) {
                int row = destination.getX();int col = source.getY();
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)||!(chessComponents[row+1][col] instanceof EmptySlotComponent)) {
                     return false;
                }else {return true;}
            }
            else // Not on the same row or the same column.
                if (source.getX() -1 == destination.getX()&&source.getY() == destination.getY()) {
                    int row = destination.getX();int col = source.getY();
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }else {return true;}
                }
                else if (x == -1 && (y == -1 || y == 1) && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
                    return true;
                }
                
        }
        return false;
    }
}
