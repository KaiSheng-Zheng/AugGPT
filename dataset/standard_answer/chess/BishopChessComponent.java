import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
       int m =this.getSource().getX();
       int n =this.getSource().getY();
       int i = 1;
        while( m+i < 8 && n+i <8 && m+i>=0 && n+i>=0 ){
            if(chessComponents[m+i][n+i]==null){
                System.out.println("null");
            }
            if (chessComponents[m+i][n+i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m+i][n+i].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(i,i));
                if (chessComponents[m+i][n+i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while( m+i < 8 && n-i >= 0 && m+i>=0 && n-i<8){
            if (chessComponents[m+i][n-i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m+i][n-i].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(i,-i));
                if (chessComponents[m+i][n-i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while( m-i >= 0 && n+i <8 && m-i<8 && n+i>=0 ){
            if (chessComponents[m-i][n+i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m-i][n+i].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-i,i));
                if (chessComponents[m-i][n+i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        i=1;
        while( m-i >= 0 && n-i >= 0 && m-i<8 && n-i<8){
            if (chessComponents[m-i][n-i].getChessColor()==this.getChessColor()){
                break;
            }
            if (chessComponents[m-i][n-i].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-i,-i));
                if (chessComponents[m-i][n-i].getChessColor()==ChessColor.NONE){
                    i++;
                }
                else {
                    break;
                }
            }
        }
        return result;
    }
}
