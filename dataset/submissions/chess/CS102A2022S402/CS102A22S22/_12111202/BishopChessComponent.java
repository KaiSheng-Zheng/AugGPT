import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List x=new ArrayList<>();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination =new ChessboardPoint(i,j);
                if(getSource().getY() + getSource().getX() != destination.getX() + destination.getY()&&
                        getSource().getY() - getSource().getX() != destination.getY() - destination.getX()){
                    continue;
                }
                if (getSource().getY() + getSource().getX() == destination.getX() + destination.getY()){
                    if (getSource().getX() <= destination.getX()){
                            if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                continue;
                            }
                    }
                    else {
                            if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                continue;
                            }
                    }
                }
                else if (getSource().getY() - getSource().getX() == destination.getY() - destination.getX()){
                    if (getSource().getX() <= destination.getX()){
                            if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                continue;
                            }
                    }
                    else {
                            if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                continue;
                            }
                    }
                }
                x.add(destination);
            }}
        return x;
    }
}
