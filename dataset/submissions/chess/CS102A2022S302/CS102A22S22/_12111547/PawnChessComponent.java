import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int m =this.getSource().getX();
        int n =this.getSource().getY();
        if (this.getChessColor()==ChessColor.BLACK){
            if (m==1){
                if (chessComponents[m+1][n].getChessColor()==ChessColor.NONE){
                    result.add(this.getSource().offset(1,0));
                    if (chessComponents[m+2][n].getChessColor()==ChessColor.NONE){
                        result.add(this.getSource().offset(2,0));
                    }
                }
            }
            if (m+1 <8){
                if (m!=1 && chessComponents[m+1][n].getChessColor()==ChessColor.NONE){
                    result.add(this.getSource().offset(1,0));
                }
            }
            //
            if (m+1 < 8 && n+1 <8){
                if (chessComponents[m+1][n+1].getChessColor()==ChessColor.WHITE ){
                    result.add(this.getSource().offset(1,1));
                }
            }
            if (m+1 < 8 && n-1 >= 0){
                if ( chessComponents[m+1][n-1].getChessColor()==ChessColor.WHITE){
                    result.add(this.getSource().offset(1,-1));
                }
            }

            //
        }
        ////
        if (this.getChessColor()==ChessColor.WHITE){
            if (m==6){
                if (chessComponents[m-1][n].getChessColor()==ChessColor.NONE){
                    result.add(this.getSource().offset(-1,0));
                    if (chessComponents[m-2][n].getChessColor()==ChessColor.NONE){
                        result.add(this.getSource().offset(-2,0));
                    }
                }
            }
            if (m-1 >= 0){
                if (m!=6 && chessComponents[m-1][n].getChessColor()==ChessColor.NONE){
                    result.add(this.getSource().offset(-1,0));
                }
            }
            if (m-1 >= 0 && n+1 <8){
                if (chessComponents[m-1][n+1].getChessColor()==ChessColor.BLACK ){
                    result.add(this.getSource().offset(-1,1));
                }
            }
            if (m-1 >= 0 && n-1 >= 0){
                if ( chessComponents[m-1][n-1].getChessColor()==ChessColor.BLACK){
                    result.add(this.getSource().offset(-1,-1));
                }
            }
        }
        return result;
    }
}
