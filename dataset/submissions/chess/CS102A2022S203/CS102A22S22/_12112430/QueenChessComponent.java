import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
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
        int x=destination.getX()-source.getX();
        int y=destination.getY()-source.getY();
        if (x==y&&x>0) {
            for (int t = 1; t < x; t++) {
                if (!(chessComponents[source.getX()+t][source.getY()+t] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (x==y&&x<0) {
            for (int t = -1; t > x; t--) {
                if (!(chessComponents[source.getX()+t][source.getY()+t] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (x==-y&&x>0) {
            for (int t = 1; t < x; t++) {
                if (!(chessComponents[source.getX()+t][source.getY()-t] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (x==-y&&x<0) {
            for (int t = -1; t > x; t--) {
                if (!(chessComponents[source.getX()+t][source.getY()-t] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (x==0) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (y==0) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
             return false;
        }
        return true;
    }

}
