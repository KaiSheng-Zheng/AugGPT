import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        for (int i = 0; i < (8-this.getSource().getX()); i++) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,0));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()])){
                        move.add(this.getSource().offset(i,0));break;
                    }else {
                        break;
                    }
                }
            }

        }
        for (int i = 0; i > (-1-this.getSource().getX()); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,0));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()])){
                        move.add(this.getSource().offset(i,0));break;
                    }else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < (8-this.getSource().getY()); i++) {
            if (i!=0){
                if (chessboard[this.getSource().getX()][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(0,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(0,i));break;
                    }else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i > (-1-this.getSource().getY()); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(0,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(0,i));break;
                    }else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < (8-Math.max(this.getSource().getX(),this.getSource().getY())); i++) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(i,i));break;
                    }else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i > (-1-Math.min(this.getSource().getX(),this.getSource().getY())); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(i,i));break;
                    }else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i <= this.getSource().getX(); i++) {
                if (i!=0){
                    if (chessboard[this.getSource().getX()][this.getSource().getY()].getSource().isInChessboard(-i,i)){
                        if (chessboard[this.getSource().getX()-i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                            move.add(this.getSource().offset(-i,i));
                        }else{
                            if (isEnemy(chessboard[this.getSource().getX()-i][this.getSource().getY()+i])){
                                move.add(this.getSource().offset(-i,i));
                            }
                            break;
                        }
                    }
                    else break;
                }
        }
        for (int i = 0; i >= -this.getSource().getY(); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()][this.getSource().getY()].getSource().isInChessboard(-i,i)){
                    if (chessboard[this.getSource().getX()-i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                        move.add(this.getSource().offset(-i,i));
                    }else{
                        if (isEnemy(chessboard[this.getSource().getX()-i][this.getSource().getY()+i])){
                            move.add(this.getSource().offset(-i,i));
                        }
                        break;
                    }
                }
                else break;
            }
        }
        return move;
    }

}
