import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){
        if (this.getChessColor()==ChessColor.BLACK){
            name='K';
        }else {
            name='k';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        if (source.getX()+1<8) {
            if (chessboard[source.getX()+1][source.getY()].getChessColor() != this.getChessColor()) {
                result.add(source.offset(1, 0));
            }
        }
        if (source.getX()+1<8 && source.getY()+1<8) {
            if (chessboard[source.getX()+1][source.getY()+1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(1, 1));
            }
        }
        if (source.getY()+1<8) {
            if (chessboard[source.getX()][source.getY()+1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(0, 1));
            }
        }
        if (source.getX()-1>=0 && source.getY()+1<8) {
            if (chessboard[source.getX()-1][source.getY()+1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-1, 1));
            }
        }
        if (source.getX()-1>=0) {
            if (chessboard[source.getX()-1][source.getY()].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-1, 0));
            }
        }
        if (source.getX()-1>=0 && source.getY()-1>=0) {
            if (chessboard[source.getX()-1][source.getY()-1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(-1, -1));
            }
        }
        if (source.getY()-1>=0) {
            if (chessboard[source.getX()][source.getY()-1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(0, -1));
            }
        }
        if (source.getX()+1<8 && source.getY()-1>=0) {
            if (chessboard[source.getX()+1][source.getY()-1].getChessColor() != this.getChessColor()) {
                result.add(source.offset(1, -1));
            }
        }
        if (result.size()==0){
            return new ArrayList<>();
        }else {
            return result;
        }
    }
}
