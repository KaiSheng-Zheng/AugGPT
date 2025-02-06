import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';}
        else if (chessColor == ChessColor.WHITE){
            this.name = 'k';}
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        for(int i = -1 ; i <  2; i++){
            for (int j = -1 ; j < 2; j++) {
                ChessboardPoint newPlace = getSource().offset(i,j);
                if(newPlace != null && newPlace !=  getSource()  &&
                        getComponentColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0)) != getChessColor()){
                    moveTo.add(newPlace);
                }
            }
        }
        return moveTo;
    }
}
