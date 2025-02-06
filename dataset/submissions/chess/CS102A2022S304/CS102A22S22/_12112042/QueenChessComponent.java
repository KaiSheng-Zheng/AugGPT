import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);
                if(source.getX() == i){
                    int temp = 0;
                    for (int col = Math.min(source.getY(), chessboardPoint.getY()) + 1;
                         col < Math.max(source.getY(), chessboardPoint.getY()); col++) {
                        if (!(chessboard[i][col] instanceof EmptySlotComponent)) {
                            temp++;
                        }
                    }if(temp==0 && chessboard[i][j].chessColor!=this.chessColor){
                        list.add(chessboardPoint);
                    }
                }
                if(source.getY() == j){
                    int temp = 0;
                    for (int row = Math.min(source.getX(), chessboardPoint.getX()) + 1;
                         row < Math.max(source.getX(), chessboardPoint.getX()); row++) {
                        if (!(chessboard[row][j] instanceof EmptySlotComponent)) {
                            temp++;
                        }
                    }if(temp==0 && chessboard[i][j].chessColor!=this.chessColor){
                        list.add(chessboardPoint);
                    }
                }
                if(Math.abs(source.getX() - chessboardPoint.getX()) == Math.abs(source.getY() - chessboardPoint.getY())){
                    int temp = 0;
                    if(source.getX()!= i && source.getY()!= j){
                        if((source.getY() - j)/(source.getX() - i)==1){
                            for (int col = Math.min(source.getY(), j) + 1; col < Math.max(source.getY(), j); col++) {
                                int a  = source.getY() - source.getX();  //y-x=a
                                if (!(chessboard[col-a][col] instanceof EmptySlotComponent)) {
                                    temp++;
                                }
                            }if(temp==0 && chessboard[i][j].chessColor!=this.chessColor){
                                list.add(chessboardPoint);
                            }
                        }else{
                            for (int row = Math.min(source.getX(), i) + 1; row < Math.max(source.getX(), i); row++){
                                int b  = source.getX() + source.getY(); //y+x=b
                                if (!(chessboard[row][b-row] instanceof EmptySlotComponent)) {
                                    temp++;
                                }
                            }if(temp==0 && chessboard[i][j].chessColor!=this.chessColor){
                                list.add(chessboardPoint);
                            }
                        }
                    }

                }
            }
        }
        if(list.size() == 0){
            return new ArrayList<>();
        }else{
            return list;
        }
    }
}
