import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK){
            setName('K');
        }
        else{
            setName('k');
        }
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public boolean canMove(ChessComponent[][] chessComponents, ChessboardPoint source, ChessboardPoint destination) {
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessColor){
            return false;
        }
        else {
            if (source.getX() == destination.getX()) {
                if(Math.abs(source.getY() - destination.getY()) != 1){
                    return false;
                }
            }
            else if(source.getY() == destination.getY()) {
                if(Math.abs(source.getX() - destination.getX()) != 1){
                    return false;
                }
            }
            else if(Math.abs(destination.getX()-source.getX()) ==Math.abs(destination.getY()-source.getY())){
                if(Math.abs(destination.getX() - source.getX()) != 1){
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;

    }

    public  List<ChessboardPoint> canMoveTo(){
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
