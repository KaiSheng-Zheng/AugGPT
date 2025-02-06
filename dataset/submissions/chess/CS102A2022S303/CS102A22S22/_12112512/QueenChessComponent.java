import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> Q = new ArrayList<>();
            for(int i = 0; i < 8; i++){
                for(int k = 0; k < 8; k++){
                    if(canMoveTo1(getChessComponents(),new ChessboardPoint(i,k))){
                        Q.add(new ChessboardPoint(i,k));

                    }
                }
            }
        System.out.println(Q);
            return Q;
        }
    public boolean canMoveTo1(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getX() == destination.getX()) {
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
        } else if (source.getY() - destination.getY() == source.getX() - destination.getX()){
            int col = Math.min(source.getY(), destination.getY()) ;
            int row = Math.min(source.getX(), destination.getX()) ;
            for (int i = 0;i <= Math.abs(source.getX() - destination.getX())-2;i++
            ) {
                col = col + 1;
                row = row + 1;
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() - destination.getY() == -(source.getX() - destination.getX())){
            int col = Math.max(source.getY(), destination.getY()) ;
            int row = Math.min(source.getX(), destination.getX()) ;
            for (int i = 0;i <= Math.abs(source.getX() - destination.getX())-2;i++
            ) {
                col = col - 1;
                row = row + 1;
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        if(chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        return true;
    }
    public QueenChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
    }
}