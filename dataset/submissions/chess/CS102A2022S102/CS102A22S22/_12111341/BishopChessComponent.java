import java.util.LinkedList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessColor color, ChessboardPoint chessboardPoint){
        if (color.equals(ChessColor.BLACK)){
            this.name='B';
        }else {
            this.name='b';
        }
        this.setSource(chessboardPoint);
        this.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> arrayList = new LinkedList<>();
        ChessColor selectColor =chessboard[x][y].getChessColor();

        for (int i=1;i<=Math.min(x,y);i++){
            if (chessboard[x-i][y-i].getChessColor()!=ChessColor.NONE){
                if (chessboard[x-i][y-i].getChessColor()==selectColor){
                    break;
                }else {
                    arrayList.add(chessboard[x-i][y-i].getSource());
                    break;
                }
            }else {
                arrayList.add(chessboard[x-i][y-i].getSource());
            }
        }for (int i=1;i<=Math.min(x,7-y);i++){
            if (chessboard[x-i][y+i].getChessColor()!=ChessColor.NONE){
                if (chessboard[x-i][y+i].getChessColor()==selectColor){
                    break;
                }else {
                    arrayList.add(chessboard[x-i][y+i].getSource());
                    break;
                }
            }else {
                arrayList.add(chessboard[x-i][y+i].getSource());
            }
        }for (int i=1;i<=Math.min(7-x,7-y);i++){
            if (chessboard[x+i][y+i].getChessColor()!=ChessColor.NONE){
                if (chessboard[x+i][y+1].getChessColor()==selectColor){
                    break;
                }else {
                    arrayList.add(chessboard[x+i][y+i].getSource());
                    break;
                }
            }else {
                arrayList.add(chessboard[x+i][y+i].getSource());
            }
        }for (int i=1;i<=Math.min(7-x,y);i++){
            if (chessboard[x+i][y-i].getChessColor()!=ChessColor.NONE){
                if (chessboard[x+i][y-i].getChessColor()==selectColor){
                    break;
                }else {
                    arrayList.add(chessboard[x+i][y-i].getSource());
                    break;
                }
            }else {
                arrayList.add(chessboard[x+i][y-i].getSource());
            }
        }

        return arrayList;
    }

}
