import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(){
        if (this.getChessColor()==ChessColor.BLACK){
            name='P';
        }else {
            name='p';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        if (getChessColor()==ChessColor.BLACK){
            if (source.getX()==1){
                if ((chessboard[2][source.getY()] instanceof EmptySlotComponent)){
                    result.add(source.offset(1, 0));
                }
                if (chessboard[3][source.getY()] instanceof EmptySlotComponent){
                    result.add(source.offset(2,0));
                }
            }else {
                if (chessboard[source.getX()+1][source.getY()] instanceof EmptySlotComponent) {
                    result.add(source.offset(1, 0));
                }
            }
            if (source.getX()+1<8 && source.getY()+1<8){
                if (chessboard[source.getX()+1][source.getY()+1].getChessColor() != this.getChessColor() && !(chessboard[source.getX()+1][source.getY()+1] instanceof EmptySlotComponent) ) {
                    result.add(source.offset(1, 1));
                }
            }
            if (source.getX()+1<8 && source.getY()-1>=0){
                if (chessboard[source.getX()+1][source.getY()-1].getChessColor() != this.getChessColor() && !(chessboard[source.getX()+1][source.getY()-1] instanceof EmptySlotComponent)) {
                    result.add(source.offset(1, -1));
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE){
            if (source.getX()==6){
                if (chessboard[5][source.getY()] instanceof EmptySlotComponent){
                        result.add(source.offset(-1, 0));
                }
                if (chessboard[4][source.getY()] instanceof EmptySlotComponent) {
                    result.add(source.offset(-2, 0));
                }
            }else {
                if (chessboard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {
                    result.add(source.offset(-1, 0));
                }
            }
            if (source.getX()-1>=0 && source.getY()+1<8){
                if (chessboard[source.getX()-1][source.getY()+1].getChessColor() != this.getChessColor() && !(chessboard[source.getX()-1][source.getY()+1] instanceof EmptySlotComponent)) {
                    result.add(source.offset(-1, 1));
                }
            }
            if (source.getX()-1>=0 && source.getY()-1>=0){
                if (chessboard[source.getX()-1][source.getY()-1].getChessColor() != this.getChessColor() && !(chessboard[source.getX()-1][source.getY()-1] instanceof EmptySlotComponent)) {
                    result.add(source.offset(-1, -1));
                }
            }
        }
        if (result.size()==0){
            return new ArrayList<>();
        }else {
            return result;
        }
    }
}
