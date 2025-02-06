import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e) {
        super( x, y , chessColor, name,e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        
                  int x = source.getX(); int y = source.getY();
                for (int i = 1; i < 8; i++) {
                    ChessboardPoint  temp = source.offset(i,i);
                    if(temp !=null){
                        if(chessComponents[x+i][y+i].chessColor ==ChessColor.NONE) {
                            chessboardPoints.add(temp);
                        }
                        else if(chessComponents[x+i][y+i].chessColor ==chessColor){
                            break;
                        }
                        else {
                            chessboardPoints.add(temp);
                            break;
                        }
                    }
                }
                for (int i = 1; i < 8; i++) {
                    ChessboardPoint  temp = source.offset(i,-i);
                    if(temp !=null){
                        if(chessComponents[x+i][y-i].chessColor ==ChessColor.NONE) {
                            chessboardPoints.add(temp);
                        }
                        else if(chessComponents[x+i][y-i].chessColor ==chessColor){
                            break;
                        }
                        else {
                            chessboardPoints.add(temp);
                            break;
                        }
                    }
                }
                for (int i = -1; i > - 8; i--) {
                    ChessboardPoint  temp = source.offset(i,i);
                    if(temp !=null){
                        if(chessComponents[x+i][y+i].chessColor ==ChessColor.NONE) {
                            chessboardPoints.add(temp);
                        }
                        else if(chessComponents[x+i][y+i].chessColor ==chessColor){
                            break;
                        }
                        else {
                            chessboardPoints.add(temp);
                            break;
                        }
                    }
                }
                for (int i = -1; i > - 8; i--) {
                    ChessboardPoint  temp = source.offset(i,-i);
                    if(temp !=null){
                        if(chessComponents[x+i][y-i].chessColor ==ChessColor.NONE) {
                            chessboardPoints.add(temp);
                        }
                        else if(chessComponents[x+i][y-i].chessColor ==chessColor){
                            break;
                        }
                        else {
                            chessboardPoints.add(temp);
                            break;
                        }
                    }
                }
        return chessboardPoints;
    }
}
