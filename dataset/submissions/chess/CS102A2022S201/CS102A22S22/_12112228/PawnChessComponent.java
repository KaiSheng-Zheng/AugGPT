import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e) {
        super( x, y , chessColor, name,e);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = source.getX(); int y = source.getY();
         if(chessColor == ChessColor.BLACK){
             if(source.getX()==1){
                 if(chessComponents[x+1][y] .chessColor  == ChessColor.NONE){
                     chessboardPoints.add(source.offset(1, 0));
                     if(chessComponents[x+2][y] .chessColor == ChessColor.NONE &&chessComponents[x+1][y] .chessColor != ChessColor.WHITE){
                         chessboardPoints.add(source.offset(2, 0));
                     }
                 }
                 if(source.offset(1, 1)!=null) {
                     if (chessComponents[x + 1][y+1].chessColor == ChessColor.WHITE){
                         chessboardPoints.add(source.offset(1, 1));
                     }
                 }
                 if(source.offset(1, -1)!=null) {
                     if (chessComponents[x + 1][y-1].chessColor == ChessColor.WHITE){
                         chessboardPoints.add(source.offset(1, -1));
                     }
                 }
             }
             else {
                 if(source.offset(1,0) !=null) {
                     if(chessComponents[x+1][y] .chessColor== ChessColor.NONE) chessboardPoints.add(source.offset(1, 0));
                 }
                 if(source.offset(1, 1)!=null) {
                     if (chessComponents[x + 1][y+1].chessColor == ChessColor.WHITE){
                         chessboardPoints.add(source.offset(1, 1));
                     }
                 }
                 if(source.offset(1, -1)!=null) {
                     if (chessComponents[x + 1][y-1].chessColor == ChessColor.WHITE){
                         chessboardPoints.add(source.offset(1, -1));
                     }
                 }
             }
         }
        if(chessColor == ChessColor.WHITE) {
            if (source.getX() == 6) {
                if (chessComponents[x - 1][y].chessColor == ChessColor.NONE) {
                    chessboardPoints.add(source.offset(-1, 0));
                    if (chessComponents[x - 2][y].chessColor == ChessColor.NONE && chessComponents[x - 1][y].chessColor != ChessColor.BLACK) {
                        chessboardPoints.add(source.offset(-2, 0));
                    }
                }
                if(source.offset(-1, 1)!=null) {
                    if (chessComponents[x - 1][y+1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(source.offset(-1, 1));
                    }
                }
                if(source.offset(-1, -1)!=null) {
                    if (chessComponents[x -1][y-1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(source.offset(-1, -1));
                    }
                }
            } else {
                if (source.offset(-1, 0) != null) {
                    if (chessComponents[x -1][y].chessColor == ChessColor.NONE) chessboardPoints.add(source.offset(-1, 0));
                }
                if(source.offset(-1, 1)!=null) {
                    if (chessComponents[x - 1][y+1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(source.offset(-1, 1));
                    }
                }
                if(source.offset(-1, -1)!=null) {
                    if (chessComponents[x -1][y-1].chessColor == ChessColor.BLACK){
                        chessboardPoints.add(source.offset(-1, -1));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
