import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(int x, int y, ChessColor chessColor, char name,ChessComponent[][] e) {
        super(x, y, chessColor, name,e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = source.getX();int y = source.getY();
        for(int i  =  -1;  i > -8;  i --){
            if(source.offset(i,0)!= null){
                if(chessComponents[x+i][y].chessColor ==ChessColor.NONE){
                    chessboardPoints.add(source.offset(i,0));
                }
                else if(chessComponents[x+i][y].chessColor ==chessColor){
                    break;
                }
                else {
                    chessboardPoints.add(source.offset(i,0));
                    break;
                }
            }
        }
        for(int i  =  1;  i < 8;  i ++){
            if(source.offset(i,0)!= null){
                if(chessComponents[x+i][y].chessColor ==ChessColor.NONE){
                    chessboardPoints.add(source.offset(i,0));
                }
                else if(chessComponents[x+i][y].chessColor ==chessColor){
                    break;
                }
                else {
                    chessboardPoints.add(source.offset(i,0));
                    break;
                }
            }
        }
        for(int i  =  -1;  i >-8 ;  i --){
            if(source.offset(0,i)!= null){
                if(chessComponents[x][y+i].chessColor ==ChessColor.NONE){
                    chessboardPoints.add(source.offset(0,i));
                }
                else if(chessComponents[x][y+i].chessColor ==chessColor){
                    break;
                }
                else {
                    chessboardPoints.add(source.offset(0,i));
                    break;
                }
            }
        }
        for(int i  =  1;  i < 8;  i ++){
            if(source.offset(0,i)!= null){
                if(chessComponents[x][y+i].chessColor ==ChessColor.NONE){
                    chessboardPoints.add(source.offset(0,i));
                }
                else if(chessComponents[x][y+i].chessColor ==chessColor){
                    break;
                }
                else {
                    chessboardPoints.add(source.offset(0,i));
                    break;
                }
            }
        }
                 return  chessboardPoints;
     }
}
