import java.util.LinkedList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessColor color,ChessboardPoint chessboardPoint){
        if (color.equals(ChessColor.BLACK)){
            this.name='Q';
        }else {
            this.name='q';
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
