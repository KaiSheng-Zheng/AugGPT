import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(){
        if (this.getChessColor()==ChessColor.BLACK){
            name='N';
        }else {
            name='n';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        if (source.getX()+2<8 && source.getY()+1<8) {
            if (chessboard[source.getX()+2][source.getY()+1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(2, 1));
            }
        }
        if (source.getX()+1<8 && source.getY()+2<8) {
            if (chessboard[source.getX()+1][source.getY()+2].getChessColor() != this.getChessColor()) {
                result.add(source.offset(1, 2));
            }
        }
        if (source.getX()-2>=0 && source.getY()+1<8) {
            if (chessboard[source.getX()-2][source.getY()+1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-2, 1));
            }
        }
        if (source.getX()-1>=0 && source.getY()+2<8) {
            if (chessboard[source.getX()-1][source.getY()+2].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-1, 2));
            }
        }
        if (source.getX()+2<8 && source.getY()-1>=0) {
            if (chessboard[source.getX()+2][source.getY()-1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(2, -1));
            }
        }
        if (source.getX()+1<8 && source.getY()-2>=0) {
            if (chessboard[source.getX()+1][source.getY()-2].getChessColor() != this.getChessColor()) {
                result.add(source.offset(1, -2));
            }
        }
        if (source.getX()-2>=0 && source.getY()-1>=0) {
            if (chessboard[source.getX()-2][source.getY()-1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-2, -1));
            }
        }
        if (source.getX()-1>=0 && source.getY()-2>=0) {
            if (chessboard[source.getX()-1][source.getY()-2].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-1, -2));
            }
        }
        if (result.size()==0){
            return new ArrayList<>();
        }else {
            return result;
        }
    }
}
