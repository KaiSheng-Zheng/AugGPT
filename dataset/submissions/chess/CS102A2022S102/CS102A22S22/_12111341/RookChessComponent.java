import java.util.LinkedList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessColor color, ChessboardPoint chessboardPoint){if (color.equals(ChessColor.BLACK)){
        this.name='R';
    }else {
        this.name='r';
    }
        this.setSource(chessboardPoint);
        this.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> arrayList=new LinkedList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x != 0) {
            for (int i=x-1;i>=0;i--){
                if (chessboard[i][y].getChessColor()!=ChessColor.NONE){
                    if (chessboard[i][y].getChessColor()==chessboard[x][y].getChessColor()){
                        break;
                    }else {
                        arrayList.add(chessboard[i][y].getSource());
                        break;
                    }
                }else {
                    arrayList.add(chessboard[i][y].getSource());
                }
            }
        }
        if (x!=7){
            for (int i=x+1;i<8;i++){
                if (chessboard[i][y].getChessColor()!=ChessColor.NONE){
                    if (chessboard[i][y].getChessColor()==chessboard[x][y].getChessColor()){
                        break;
                    }else {
                        arrayList.add(chessboard[i][y].getSource());
                        break;
                    }
                }else {
                    arrayList.add(chessboard[i][y].getSource());
                }
            }
        }
        if (y!=0){
            for (int j=y-1;j>=0;j--){
                if (chessboard[x][j].getChessColor()!=ChessColor.NONE){
                    if (chessboard[x][j].getChessColor()==chessboard[x][y].getChessColor()){
                        break;
                    }else {
                        arrayList.add(chessboard[x][j].getSource());
                        break;
                    }
                }else {
                    arrayList.add(chessboard[x][j].getSource());
                }
            }
        }
        if (y!=7){
            for (int j=y+1;j<8;j++){
                if (chessboard[x][j].getChessColor()!=ChessColor.NONE){
                    if (chessboard[x][j].getChessColor()==chessboard[x][y].getChessColor()){
                        break;
                    }else {
                        arrayList.add(chessboard[x][j].getSource());
                        break;
                    }
                }else {
                    arrayList.add(chessboard[x][j].getSource());
                }
            }
        }

        return arrayList;
    }
}
