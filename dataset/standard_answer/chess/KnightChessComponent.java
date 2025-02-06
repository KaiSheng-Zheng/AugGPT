import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int m =this.getSource().getX();
        int n =this.getSource().getY();

        if (m+1 < 8 && n+2 < 8){
            if (chessComponents[m+1][n+2].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(1,2));
            }
        }

        if (m+2 < 8 && n+1 < 8){
            if (chessComponents[m+2][n+1].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(2,1));
            }
        }

        if (m-1 >= 0 && n-2 >= 0){
            if (chessComponents[m-1][n-2].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-1,-2));
            }
        }

        if (m-2 >= 0 && n-1 >= 0){
            if (chessComponents[m-2][n-1].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-2,-1));
            }
        }

        if (m-2 >= 0 && n+1 < 8){
            if (chessComponents[m-2][n+1].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-2,1));
            }
        }

        if (m-1 >= 0 && n+2 < 8){
            if (chessComponents[m-1][n+2].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(-1,2));
            }
        }

        if (n-2 >= 0 && m+1 < 8){
            if (chessComponents[m+1][n-2].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(1,-2));
            }
        }

        if (n-1 >= 0 && m+2 < 8){
            if (chessComponents[m+2][n-1].getChessColor()!=this.getChessColor()){
                result.add(this.getSource().offset(2,-1));
            }
        }

        return result;
    }
}
