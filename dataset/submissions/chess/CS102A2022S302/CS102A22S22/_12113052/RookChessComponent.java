import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){
    }
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name=chessColor==ChessColor.BLACK?'R':'r';
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveTo=new ArrayList<>();
        /*for (int i = 0; i < 7; i++) {
            canMoveTo.add(getSource().offset(i,0));
            canMoveTo.add(getSource().offset(0,i));
        }*/
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()+i<8){
                if (chessComponents[getSource().getX()+i][getSource().getY()]instanceof EmptySlotComponent){
                    canMoveTo.add(getSource().offset(i,0));
                }else if (chessComponents[getSource().getX()+i][getSource().getY()].getChessColor()!=getCurrentPlayer()){
                    canMoveTo.add(getSource().offset(i,0));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getY()+i<8){
                if (chessComponents[getSource().getX()][getSource().getY()+i]instanceof EmptySlotComponent){
                    canMoveTo.add(getSource().offset(0,i));
                }else if (chessComponents[getSource().getX()][getSource().getY()+i].getChessColor()!=getCurrentPlayer()){
                    canMoveTo.add(getSource().offset(0,i));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getX()-i>=0) {
                if (chessComponents[getSource().getX()-i][getSource().getY()]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(-i, 0));
                } else if (chessComponents[getSource().getX() -i][getSource().getY()].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(-i, 0));
                    break;
                }else break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (getSource().getY()-i>=0) {
                if (chessComponents[getSource().getX()][getSource().getY()-i]instanceof EmptySlotComponent) {
                    canMoveTo.add(getSource().offset(0, -i));
                } else if (chessComponents[getSource().getX() ][getSource().getY()-i].getChessColor() != getCurrentPlayer()) {
                    canMoveTo.add(getSource().offset(0, -i));
                    break;
                }else break;
            }
        }
        return canMoveTo;
    }


    public ChessColor getCurrentPlayer(){
        if (this.name=='R'){
            return ChessColor.BLACK;
        }else return ChessColor.WHITE;
    }
}
