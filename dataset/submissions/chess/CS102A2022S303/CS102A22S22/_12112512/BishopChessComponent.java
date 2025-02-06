import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> B = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (canMoveTo1(getChessComponents(), new ChessboardPoint(i, k))) {
                    B.add(new ChessboardPoint(i, k));

                }
            }
        }
        return B;
    }
    public boolean canMoveTo1(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getY() - destination.getY() == source.getX() - destination.getX()){
            int col = Math.min(source.getY(), destination.getY()) ;
            int row = Math.min(source.getX(), destination.getX()) ;
            for (int i = 0;i <= Math.abs(source.getX() - destination.getX())-2;i++
            ) {
                col = col + 1;
                row = row + 1;
                if(row<0||row>7||col<0||col>7){
                    return false;
                }
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
                if(row<0||row>7||col<0||col>7){
                    return false;
                }
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        if(chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        return true;
    }
    public BishopChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
    }
}
