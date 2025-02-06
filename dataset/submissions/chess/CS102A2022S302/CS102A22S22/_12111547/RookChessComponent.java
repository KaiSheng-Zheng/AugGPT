
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int m = this.getSource().getX();
        int n = this.getSource().getY();

        int i = 1;
//        while (n + i < 8 && n + i >= 0 && m < 8 && m >= 0) {
//            if (chessComponents[m][n + i].getChessColor() == this.getChessColor()) {
//                break;
//            }
//            if (chessComponents[m][n + i].getChessColor() != this.getChessColor()) {
//                result.add(getSource().offset(0, i));
//                if (chessComponents[m][n + i].getChessColor() == ChessColor.NONE) {
//                    i++;
//                } else {
//                    break;
//                }
//            }
//        }
//        i = 1;
//        while (m + i < 8 && m + i >= 0 && n < 8 && n >= 0) {
//            if (chessComponents[m + i][n].getChessColor() == this.getChessColor()) {
//                break;
//            }
//            if (chessComponents[m + i][n].getChessColor() != this.getChessColor()) {
//                result.add(getSource().offset(i, 0));
//                if (chessComponents[m + i][n].getChessColor() == ChessColor.NONE) {
//                    i++;
//                } else {
//                    break;
//                }
//            }
//        }
//        i = 1;
//        while (n - i < 8 && n - i >= 0 && m < 8 && m >= 0) {
//            if (chessComponents[m][n - i].getChessColor() == this.getChessColor()) {
//                break;
//            }
//            if (chessComponents[m][n - i].getChessColor() != this.getChessColor()) {
//                result.add(getSource().offset(0, -i));
//                if (chessComponents[m][n - i].getChessColor() == ChessColor.NONE) {
//                    i++;
//                } else {
//                    break;
//                }
//            }
//        }
//        i = 1;
//        while (n < 8 && n >= 0 && m - i < 8 && m - i >= 0) {
//            if (chessComponents[m - i][n].getChessColor() == this.getChessColor()) {
//                break;
//            }
//            if (chessComponents[m - i][n].getChessColor() != this.getChessColor()) {
//                result.add(getSource().offset(-i, 0));
//                if (chessComponents[m - i][n].getChessColor() == ChessColor.NONE) {
//                    i++;
//                } else {
//                    break;
//                }
//            }
//        }
        while(n+i < 8 && n+i >= 0 && m<8 && m >= 0){
            if (chessComponents[m][n+i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m][n+i].getChessColor()!=this.getChessColor()){
                result.add(getSource().offset(0,i));
                if (chessComponents[m][n+i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while( m+i < 8 && m+i >= 0 && n<8 && n >= 0){
            if (chessComponents[m+i][n].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m+i][n].getChessColor()!=this.getChessColor()){
                result.add(getSource().offset(i,0));
                if (chessComponents[m+i][n].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while(n-i < 8 && n-i >= 0 && m<8 && m >= 0){
            if (chessComponents[m][n-i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m][n-i].getChessColor()!=this.getChessColor()){
                result.add(getSource().offset(0,-i));
                if (chessComponents[m][n-i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while(n < 8 && n >= 0 && m-i < 8 && m-i >= 0){
            if (chessComponents[m-i][n].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m-i][n].getChessColor()!=this.getChessColor()){
                result.add(getSource().offset(-i,0));
                if (chessComponents[m-i][n].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        return result;
    }
}
