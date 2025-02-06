import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canPoint = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i ++){
            for(int t = 0 ; t < 8 ; t++){
                int can = 0;
                ChessboardPoint destination = new ChessboardPoint(i ,t) ;
                ChessboardPoint source = getChessboardPoint();
                if(chessComponents[destination.getX()][destination.getY()].getChessColor()==getChessColor()){
                    continue;
                }
                if (source.getX() == destination.getX()) {
                    int row = source.getX();
                    for (int col = Math.min(source.getY(), destination.getY()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            can++;
                            break;//can't move , no return
                        }
                    }
                    if(can != 0 ){
                        continue;
                    }
                } else if (source.getY() == destination.getY()) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            can++;
                            break;//can't move , no return
                        }
                    }
                    if(can != 0){
                        continue;
                    }
                } else { // Not on the same row or the same column.
                    continue;//can't move , no return
                }
                canPoint.add(destination);
            }
        }
        return canPoint;
    }
}
