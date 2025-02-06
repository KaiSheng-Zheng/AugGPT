import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    int countPave;



    public PawnChessComponent() {
        super();
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ConcreteChessGame pawn = new ConcreteChessGame();

        if (this.getChessColor()==ChessColor.WHITE) {
            if (!(pawn.getChess(x2, y2) instanceof EmptySlotComponent)) {
                if (this.countPave == 0) {
                    if (x2 == this.getSource().getX() && (y2 - this.getSource().getY() == 1 || y2 - this.getSource().getY() == 2)) {
                        countPave++;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (x2 == this.getSource().getX() && (y2 - this.getSource().getY() == 1)) {
                        countPave++;
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                if (!(this.getChessColor()==(pawn.getChess(x2, y2).getChessColor())) && (y2 - this.getSource().getY() == 1) && (x2 - this.getSource().getX() == 1 || x2 - this.getSource().getX() == -1)) {
                    countPave++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        else{
            if (pawn.getChess(x2, y2) instanceof EmptySlotComponent) {
                if (this.countPave == 0) {
                    if (x2 == this.getSource().getX() && (y2 - this.getSource().getY() == -1 || y2 - this.getSource().getY() == -2)) {
                        countPave++;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (x2 == this.getSource().getX() && (y2 - this.getSource().getY() == -1)) {
                        countPave++;
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                if (!(this.getChessColor()==((pawn.getChess(x2, y2).getChessColor()))) && (y2 - this.getSource().getY() == -1) && (x2 - this.getSource().getX() == 1 || x2 - this.getSource().getX() == -1)) {
                    countPave++;
                    return true;
                } else {
                    return false;
                }
            }

        }
    }
}
