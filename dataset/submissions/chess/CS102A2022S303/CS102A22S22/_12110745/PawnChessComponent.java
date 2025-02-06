import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor);
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (this.name == 'P'){
            if (this.getSource().getX() == 1){
                for (int i = 1; i < 3; i++) {
                    if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent) {
                        move.add(this.getSource().offset(i, 0));
                    }else{
                        break;
                    }
                }
            }else{
                if (chessboard[x][y].getSource().isInChessboard(1,0)){
                    if (chessboard[this.getSource().getX()+1][this.getSource().getY()] instanceof EmptySlotComponent){
                        move.add(this.getSource().offset(1,0));
                    }
                }
            }
            if (chessboard[x][y].getSource().isInChessboard(1,1)){
                if (isEnemy(chessboard[x+1][y+1]) && !isEmpty(chessboard[x+1][y+1])){
                    move.add(this.getSource().offset(1,1));
                }
            }
            if (chessboard[x][y].getSource().isInChessboard(1,-1)){
                if (isEnemy(chessboard[x+1][y-1]) && !isEmpty(chessboard[x+1][y-1])){
                    move.add(this.getSource().offset(1,1));
                }
            }
        }
        if (this.name == 'p'){
            if (this.getSource().getX() == 6){
                for (int i = 1; i < 3; i++) { // direction is incorrect here, should be getX()-i
                    if (chessboard[this.getSource().getX()+i][this.getSource().getY()] instanceof EmptySlotComponent) {
                        move.add(this.getSource().offset(-i, 0));
                    }else{
                        break;
                    }
                }
            }else{
                if (chessboard[this.getSource().getX()-1][this.getSource().getY()] instanceof EmptySlotComponent){
                    move.add(this.getSource().offset(-1,0));
                }
            }
            if (chessboard[x][y].getSource().isInChessboard(-1,1)){
                if (isEnemy(chessboard[x-1][y+1]) && !isEmpty(chessboard[x-1][y+1])){
                    move.add(this.getSource().offset(-1,1));
                }
            }
            if (chessboard[x][y].getSource().isInChessboard(-1,-1)){
                if (isEnemy(chessboard[x-1][y-1]) && !isEmpty(chessboard[x-1][y-1])){
                    move.add(this.getSource().offset(-1,1));
                }
            }
        }
        return move;
    }
}

