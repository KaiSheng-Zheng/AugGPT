import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canPoint = new ArrayList<>();
        for(int x = 0 ; x < 8 ; x ++){
            for(int y = 0 ; y < 8 ; y++) {
                ChessboardPoint destination = new ChessboardPoint(x, y);
                ChessboardPoint source = getChessboardPoint();
                if(chessComponents[destination.getX()][destination.getY()].getChessColor()==getChessColor()){
                    continue;
                }
                if (Math.abs(source.getX()-destination.getX())==Math.abs(source.getY()-destination.getY())) {
                    int can = 0;
                    for(int i = 1 ; i < Math.abs(source.getX()-destination.getX()) ; i ++){
                        if((source.getX()-destination.getX()<0)&&(source.getY()-destination.getY())<0){//
                            int row = source.getX() + i;
                            int col = source.getY() + i;
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can++;
                                break;//
                            }
                        }
                        else if((source.getX()-destination.getX()<0)&&(source.getY()-destination.getY())>0){//
                            int row = source.getX() + i;
                            int col = source.getY() - i;
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can++;
                                break;//
                            }
                        }
                        else if((source.getX()-destination.getX()>0)&&(source.getY()-destination.getY())>0){//
                            int row = source.getX() - i;
                            int col = source.getY() - i;
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can++;
                                break;//
                            }
                        }
                        else if((source.getX()-destination.getX()>0)&&(source.getY()-destination.getY())<0){//
                            int row = source.getX() - i;
                            int col = source.getY() + i;
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                can++;
                                break;//
                            }
                        }
                    }
                    if(can != 0 ){
                        continue;
                    }
                }
                else{//
                    int can = 0;
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
                }
                canPoint.add(destination);
            }
        }
        return canPoint;
    }
}

