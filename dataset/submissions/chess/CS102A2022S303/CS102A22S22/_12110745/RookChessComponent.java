import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        for (int i = 1; i < (8-this.getSource().getX()); i++) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent) {
                    move.add(this.getSource().offset(i, 0));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()])){
                        move.add(this.getSource().offset(i,0));
                    }
                    break;
                }
            }
        }
        for (int i = -1; i >(-1-this.getSource().getX()); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent) {
                    move.add(this.getSource().offset(i, 0));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()])){
                        move.add(this.getSource().offset(i,0));
                    }
                    break;
                }
            }
        }
        for (int i = 1; i < (8-this.getSource().getY()); i++){
            if (i!=0){
                if (chessboard[this.getSource().getX()][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(0,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(0,i));
                    }
                    break;
                }
            }
        }
        for (int i = -1; i > (-1-this.getSource().getY()); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(0,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(0,i));
                    }
                    break;
                }
            }
        }
        return move;
    }
}
