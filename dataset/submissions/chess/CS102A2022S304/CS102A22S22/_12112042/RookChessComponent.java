import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent() {

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
                    }
                    if(temp == 0 && chessboard[i][j].chessColor != this.chessColor){
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
                    }
                    if(temp == 0 && chessboard[i][j].chessColor != this.chessColor){
                        list.add(chessboardPoint);
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

