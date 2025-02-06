import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 1;i<8;i++) {
            if (x + i < 8 && y + i < 8) {
                if (whetherhava(x + i, y + i)) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y + i));
                } else if (getChessColor() != getChessComponents()[x + i][y + i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y + i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if (x + i < 8 && y - i >= 0) {
                if (whetherhava(x + i, y - i)) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y - i));
                } else if (getChessColor() != getChessComponents()[x + i][y - i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x + i, y - i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if (x - i >= 0 && y + i < 8) {
                if (whetherhava(x - i, y + i)) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y + i));
                } else if (getChessColor() != getChessComponents()[x - i][y + i].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x - i, y + i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
            if(x-i>=0 && y-i>=0){
                if (whetherhava(x-i,y-i)){
                    chessboardPoints.add(new ChessboardPoint(x-i,y-i));
                }else if (getChessColor() != getChessComponents()[x-i][y-i].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x-i,y-i));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = x+1;i < 8 && i >= 0;i++){
            if (whetherhava(i,y)){
                chessboardPoints.add(new ChessboardPoint(i,y));
            }else if (getChessColor() == getChessComponents()[i][y].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(i,y));
                break;
            }
        }
        for (int i = x-1;i < 8 && i >= 0;i--){
            if (whetherhava(i,y)){
                chessboardPoints.add(new ChessboardPoint(i,y));
            }else if (getChessColor() == getChessComponents()[i][y].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(i,y));
                break;
            }
        }
        for (int i = y+1;i < 8 && i >= 0;i++){
            if (whetherhava(x,i)){
                chessboardPoints.add(new ChessboardPoint(x,i));
            }else if (getChessColor() == getChessComponents()[x][i].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(x,i));
                break;
            }
        }
        for (int i = y-1;i < 8 && i >= 0;i--){
            if (whetherhava(x,i)){
                chessboardPoints.add(new ChessboardPoint(x,i));
            }else if (getChessColor() == getChessComponents()[x][i].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(x,i));
                break;
            }
        }
        return chessboardPoints;
    }
}
