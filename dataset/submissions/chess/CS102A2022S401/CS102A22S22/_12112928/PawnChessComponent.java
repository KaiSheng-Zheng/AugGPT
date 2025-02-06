
import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    private int counter=0;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
    public int getCounter(){
        return counter;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveto=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                int sign=0;
                if (getCounter() == 0) {
                    if (source.getY() == destination.getY()) {
                        if (chessColor == ChessColor.BLACK) {
                            if (destination.getX() - source.getX() == 1) {
                                if (((chessComponents[source.getX()+1][source.getY()] instanceof EmptySlotComponent))) {
                                    sign=1;
                                }
                            }
                            if (destination.getX() - source.getX() == 2){
                                if (((chessComponents[source.getX()+1][source.getY() ] instanceof EmptySlotComponent))&&((chessComponents[source.getX()+2][source.getY()] instanceof EmptySlotComponent))){
                                    sign=1;
                                }
                            }
                        }
                        if (chessColor == ChessColor.WHITE) {
                            if ((destination.getX() - source.getX() >=-2) && (destination.getX() - source.getX() < 0)) {
                                if (destination.getX() - source.getX() == -1) {
                                    if (((chessComponents[source.getX()-1][source.getY() ] instanceof EmptySlotComponent))) {
                                        sign=1;
                                    }
                                }
                                if (destination.getX() - source.getX() == -2){
                                    if (((chessComponents[source.getX()- 1][source.getY() ] instanceof EmptySlotComponent))&&((chessComponents[source.getX()- 2][source.getY() ] instanceof EmptySlotComponent))){
                                        sign=1;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        if (chessColor == ChessColor.BLACK) {
                            if(destination.getX() - source.getX()==1&&Math.abs(destination.getY()-source.getY())==1&&(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))){
                                sign=1;
                            }
                        }
                        if(chessColor==ChessColor.WHITE){
                            if(destination.getX() - source.getX()==-1&&Math.abs(destination.getY()-source.getY())==1&&(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))){
                                sign=1;
                            }
                        }
                    }
                }
                else if(getCounter()!=0) {
                    if (source.getY() == destination.getY()) {
                        if (chessColor == ChessColor.BLACK) {
                            if ((destination.getX() - source.getX() ==1) ) {
                                if (((chessComponents[source.getX() + 1][source.getY()] instanceof EmptySlotComponent))) {
                                    sign=1;
                                }
                            }
                        }
                        if (chessColor == ChessColor.WHITE) {
                            if ((destination.getX() - source.getX() ==-1)) {
                                if (((chessComponents[source.getX() - 1][source.getY()] instanceof EmptySlotComponent))) {
                                    sign=1;
                                }
                            }
                        }
                    }
                    else {
                        if (chessColor == ChessColor.BLACK) {
                            if(destination.getX() - source.getX()==1&&Math.abs(destination.getY()-source.getY())==1&&(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))){
                                sign=1;
                            }
                        }
                        if(chessColor==ChessColor.WHITE){
                            if(destination.getX() - source.getX()==-1&&Math.abs(destination.getY()-source.getY())==1&&(!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent))){
                                sign=1;
                            }
                        }
                    }
                }
                if (sign==1&&chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.chessColor){

                    moveto.add(destination);
                }
            }
        }
        return moveto;
    }
}
