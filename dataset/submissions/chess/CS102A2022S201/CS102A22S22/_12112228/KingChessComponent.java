import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    public KingChessComponent(int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e) {
             super( x, y , chessColor, name, e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        for(int i = -1 ; i <=1 ; i++){
            for(int j = -1 ; j <=1 ; j++){
                 if( i==0 && j ==0){
                     ;
                 }
                 else if(source.offset(i,j) ==null){
                     ;
                 }
                 else if(chessComponents[source.getX()+i][source.getY()+j].chessColor ==chessColor){
                                 ;
                 }
                 else {
                     chessboardPoints.add(source.offset(i,j));
                 }
            }
        }
        return chessboardPoints;
    }
}
