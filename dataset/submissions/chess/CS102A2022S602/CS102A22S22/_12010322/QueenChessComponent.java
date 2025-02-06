import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {
        super();
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }



    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.canMoveTo(i,j)){
                    ChessboardPoint kai=new ChessboardPoint(i,j);
                    canMoveTo.add(kai);
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(int x2, int y2) {
        ConcreteChessGame Queen=new ConcreteChessGame();
        if ((x2 - this.getSource().getX() != y2 - this.getSource().getY() && x2 - this.getSource().getX() != -y2 + this.getSource().getY()&&this.getSource().getX()!=x2&&this.getSource().getY()!=y2) || (this.getSource().getX() == x2 && this.getSource().getY() == y2) ){
            return false;
        } else {
            if (x2 - this.getSource().getX() == y2 - this.getSource().getY()) {
                if (x2 > this.getSource().getX()) {
                    for (int i = this.getSource().getX() + 1; i < x2; i++) {
                        if (!(Queen.getChess(i, this.getSource().getY() - this.getSource().getX() + i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getX() - 1; i > x2; i--) {
                        if (!(Queen.getChess(i, this.getSource().getY() - this.getSource().getX() + i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            } else if(x2 - this.getSource().getX() == -y2 + this.getSource().getY()){
                if (x2 > this.getSource().getX()) {
                    for (int i = this.getSource().getX() + 1; i < x2; i++) {
                        if (!(Queen.getChess(i, this.getSource().getY() + this.getSource().getX() - i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                } else {
                    for (int i = this.getSource().getX() - 1; i > x2; i--) {
                        if (!(Queen.getChess(i, this.getSource().getY() + this.getSource().getX() - i) instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }else if(this.getSource().getY()==y2){
                if(x2>this.getSource().getX()){
                    for (int i = this.getSource().getX()+1; i < x2; i++) {
                        if(!(Queen.getChess(i, y2) instanceof EmptySlotComponent)){return false;}
                    }
                }
                else {
                    for (int i = this.getSource().getX()-1; i >x2 ; i--) {
                        if(!(Queen.getChess(i, y2) instanceof EmptySlotComponent)){return false;}
                    }
                }
            }
            else {
                if(y2>this.getSource().getY()){
                    for (int i = this.getSource().getY()+1; i < y2; i++) {
                        if(!(Queen.getChess(x2,  i) instanceof EmptySlotComponent)){return false;}
                    }
                }
                else {
                    for (int i = this.getSource().getY()-1; i >y2 ; i--) {
                        if(!(Queen.getChess(x2,  i) instanceof EmptySlotComponent)){return false;}
                    }
                }
            }
            if (!(Queen.getChess(x2, y2) instanceof EmptySlotComponent)&&this.getChessColor()==(Queen.getChess(x2, y2).getChessColor())) { return false; }
            else {
                return true;
            }
}
    }

}

