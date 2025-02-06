import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        int h=0;
            List<ChessboardPoint> x=new ArrayList<>();
            for(int i=0;i<8;i++){
                for (int j=0;j<8;j++) {
                    ChessboardPoint destination = new ChessboardPoint(i, j);
                    if (getSource().getX() == destination.getX()) {
                        if (getSource().getX()<destination.getX()){
                            for (int g= getSource().getY()+1;g<destination.getY();g++){
                                if (Board.getChessComponent1()[destination.getX()][g] instanceof EmptySlotComponent) {
                                    continue;
                                }
                                h=1;
                                break;
                            }
                            if (h==1){
                                h=0;
                                continue;
                            }
                        }
                        else {
                            for (int g= getSource().getY();g>destination.getY();g--){
                                if(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                }
                                if (Board.getChessComponent1()[destination.getX()][g] instanceof EmptySlotComponent) {
                                    continue;
                                }
                                h=1;
                                break;
                            }
                            if (h==1){
                                h=0;
                                continue;
                            }
                        }
                            if (this.getChessColor()==Board.getChessComponent1()[destination.getX()][destination.getY()].getChessColor())
                            {
                                continue;
                            }
                    } else if (getSource().getY() == destination.getY()) {
                        if (getSource().getX()<destination.getX()){
                        for (int g= getSource().getX()+1;g<destination.getX();g++){
                            if (Board.getChessComponent1()[g][destination.getY()] instanceof EmptySlotComponent) {
                                continue;
                            }
                            h=1;
                            break;
                        }
                        if (h==1){
                            h=0;
                            continue;
                        }}else if (getSource().getX()>destination.getX()){
                            for (int g= getSource().getX()-1;g>destination.getX();g--){
                                if (Board.getChessComponent1()[g][destination.getY()] instanceof EmptySlotComponent) {
                                    continue;
                                }
                                h=1;
                                break;
                            }
                            if (h==1){
                                h=0;
                                continue;
                            }
                        }
                            if (!(this.getChessColor()!=Board.getChessComponent1()[destination.getX()][destination.getY()].getChessColor())) {
                                continue;
                            }
                            else {x.add(destination);}
                        continue;
                    }
                    else { // Not on the same row or the same column.
                        continue;
                    }
                }}
            return x;
        }
}
