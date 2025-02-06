

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    public KingChessComponent() {
        super();
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ConcreteChessGame King=new ConcreteChessGame();
        if((this.getSource().getX()==x2&&this.getSource().getY()==y2)||this.getSource().getY()-y2>1||this.getSource().getY()-y2<-1||this.getSource().getX()-x2>1||this.getSource().getX()-x2<-1){return false;}
        else {
            if(!(King.getChess(x2, y2) instanceof EmptySlotComponent)&&this.getChessColor()==((King.getChess(x2, y2).getChessColor()))){return false;}
        else {
            return true;}
        }
    }




}
