import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> x=new ArrayList<>();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination = new ChessboardPoint(i,j);
                if (Math.abs(destination.getX() - getSource().getX()) <= 1){
                    if (Math.abs(destination.getY() - getSource().getY()) <= 1){
                        if (Board.getChessComponent1()[destination.getX()][destination.getY()].getChessColor()!=this.getChessColor()){
                        x.add(destination);
                    }
                    }
                }
                continue;
            }}
        return x;
    }
}
