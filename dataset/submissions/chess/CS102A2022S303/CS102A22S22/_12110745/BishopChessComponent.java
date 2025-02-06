import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        for (int i = 0; i < (8-Math.max(this.getSource().getX(),this.getSource().getY())); i++) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(i,i));
                    }
                    break;
                }
            }

        }
        for (int i = 0; i > (-1-Math.min(this.getSource().getX(),this.getSource().getY())); i--) {
            if (i!=0){
                if (chessboard[this.getSource().getX()+i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(i,i));
                }else{
                    if (isEnemy(chessboard[this.getSource().getX()+i][this.getSource().getY()+i])){
                        move.add(this.getSource().offset(i,i));
                    }
                    break;
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
                }else{
                    break;
                }
            }
        }
        for (int i = 0; i >= -this.getSource().getY(); i--) {
            if (chessboard[this.getSource().getX()][this.getSource().getY()].getSource().isInChessboard(-i,i)){
                if (i!=0){
                    if (chessboard[this.getSource().getX()-i][this.getSource().getY()+i] instanceof EmptySlotComponent){
                        move.add(this.getSource().offset(-i,i));
                    }else{
                        if (isEnemy(chessboard[this.getSource().getX()-i][this.getSource().getY()+i])){
                            move.add(this.getSource().offset(-i,i));
                        }
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
        return move;
    }
}
