import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo() {
        int h=0;
        List<ChessboardPoint> x=new ArrayList<>();
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination =new ChessboardPoint(i,j);
        if((getSource().getX() != destination.getX()&&getSource().getY() != destination.getY()&&
                getSource().getY() + getSource().getX() != destination.getX() + destination.getY()&&
                getSource().getY() - getSource().getX() != destination.getY() - destination.getX())||
                (getSource().getX() == destination.getX()&&getSource().getY() == destination.getY())){
            continue;
        }
        if (getSource().getX() == destination.getX()) {
            for (int a=getSource().getY();a<=destination.getY();a++){
                if (!(Board.getChessComponent1()[destination.getX()][a] instanceof EmptySlotComponent)){
                    if (getSource().getX()==destination.getX()){
                        continue;
                    }
                    h=1;
                    break;
                }
            }
            if (h==1){
                h=0;
                continue;
            }
                if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                    continue;
                }

        }
        else if (getSource().getY() == destination.getY()) {
            for (int a=getSource().getX();a<=destination.getX();a++){
                if (!(Board.getChessComponent1()[a][destination.getY()] instanceof EmptySlotComponent)){
                    if (getSource().getY()==destination.getY()){
                        continue;
                    }
                    h=1;
                    break;
                }
            }
            if (h==1){
                h=0;
                continue;
            }
                if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                    continue;
                }
        }
        else if (getSource().getY() + getSource().getX() == destination.getX() + destination.getY()){
            if (getSource().getX() <= destination.getX()){
                for (int a=1;a<=-(getSource().getX()-destination.getX());a++){
                    if (!(Board.getChessComponent1()[getSource().getX()+a][getSource().getY()-a] instanceof EmptySlotComponent)){
                        h=1;
                        break;
                    }
                }
                if (h==1){
                    h=0;
                    continue;
                }
                    if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        continue;
                    }
            }
            else {
                for (int a=1;a<=getSource().getX()-destination.getX();a++){
                    if (!(Board.getChessComponent1()[getSource().getX()-a][getSource().getY()+a] instanceof EmptySlotComponent)){
                        h=1;
                        break;
                    }
                }
                if (h==1){
                    h=0;
                    continue;
                }
                    if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        continue;
                    }
            }
        }
        else if (getSource().getY() - getSource().getX() == destination.getY() - destination.getX()){
            if (getSource().getX() <= destination.getX()){
                for (int a=1;a<=-(getSource().getX()-destination.getX());a++){
                    if (!(Board.getChessComponent1()[getSource().getX()+a][getSource().getY()+a] instanceof EmptySlotComponent)){
                        h=1;
                        break;
                    }
                }
                if (h==1){
                    h=0;
                    continue;
                }
                   if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        continue;
                    }
            }
            else {
                for (int a=1;a<=getSource().getX()-destination.getX();a++){
                    if (!(Board.getChessComponent1()[getSource().getX()-a][getSource().getY()-a] instanceof EmptySlotComponent)){
                        h=1;
                        break;
                    }
                }
                if (h==1){
                    h=0;
                    continue;
                }
                    if (!(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        continue;
                    }
            }
        }
        x.add(destination);
    }
        }
        return x;
    }
}
