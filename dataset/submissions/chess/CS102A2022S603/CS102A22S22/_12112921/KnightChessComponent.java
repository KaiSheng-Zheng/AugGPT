import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK){
            setName('N');
        }
        else{
            setName('n');
        }
    }
    public boolean canMove(ChessComponent[][] chessComponents,ChessboardPoint source, ChessboardPoint destination) {
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessColor){
            return false;
        }
        else {
            if (((Math.abs(destination.getX()-source.getX())==2&&Math.abs(destination.getY()-source.getY())==1)||(Math.abs(destination.getX()-source.getX())==1&&Math.abs(destination.getY()-source.getY())==2))) {
                ;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>list = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canMove(chessComponents,source,new ChessboardPoint(i,j))){
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }
        return list;
    }
}
