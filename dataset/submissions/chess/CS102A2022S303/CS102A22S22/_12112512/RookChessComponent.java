import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint>  R= new ArrayList<>();
        System.out.println(canMoveTo1(getChessComponents(),new ChessboardPoint(7,5)));
       for(int i = 0; i < 8; i++){
           for(int k = 0; k < 8; k++){
               if(canMoveTo1(getChessComponents(),new ChessboardPoint(i,k))){
                   R.add(new ChessboardPoint(i,k));
               }
           }
       }
        return R;
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

        }
        else {
            return false;
        }
        if(getChessColor() == chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        return true;
    }
    public RookChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
    }
}