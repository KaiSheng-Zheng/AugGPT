import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent() {
        super();
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ConcreteChessGame Knight=new ConcreteChessGame();
        if(!((Math.abs(x2-this.getSource().getX())==1&&(Math.abs(y2-this.getSource().getY())==2)))&&!((Math.abs(x2-this.getSource().getX())==2&&(Math.abs(y2-this.getSource().getY())==1)))){return false;}
        else {
            if(!(Knight.getChess(x2,y2) instanceof EmptySlotComponent)&&this.getChessColor()==(Knight.getChess(x2,y2).getChessColor())){return false;}
            else {
                return true;}

        }

    }
}
