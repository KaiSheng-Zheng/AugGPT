import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> x=new ArrayList<>();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination =new ChessboardPoint(i,j);
                if (Math.abs(destination.getX() - getSource().getX()) * Math.abs(destination.getY() - getSource().getY()) == 2){
                    if (Board.getChessComponent1()[destination.getX()][destination.getY()].getChessColor()!=this.getChessColor()) {
                        x.add(destination);}
                else continue;}
                else{continue;}
            }}
        return x;
    }}
