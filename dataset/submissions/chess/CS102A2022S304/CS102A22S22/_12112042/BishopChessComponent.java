import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent() {

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                ChessComponent target = chessboard[i][j];
                if(source.getX() != i && source.getY() != j){
                    if (Math.abs(source.getX() - i) == Math.abs(source.getY() - j)) {
                        if((source.getY() - j)/(source.getX() - i)==1){
                            int temp1 = 0;
                            for (int col = Math.min(source.getY(), j) + 1; col < Math.max(source.getY(), j); col++) {
                                int a  = source.getY() - source.getX();  //y-x=a
                                if (!(chessboard[col-a][col] instanceof EmptySlotComponent)) {
                                    temp1 ++;
                                }
                            }if(temp1 == 0 && target.chessColor != this.chessColor){
                                list.add(chessboardPoint);
                            }
                        }else {
                            int temp1 = 0;
                            for (int row = Math.min(source.getX(), i) + 1; row < Math.max(source.getX(), i); row++){
                                int b  = source.getX() + source.getY(); //y+x=b
                                if (!(chessboard[row][b-row] instanceof EmptySlotComponent)) {
                                    temp1 ++;
                                }
                            }if(temp1 == 0 && target.chessColor != this.chessColor){
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
