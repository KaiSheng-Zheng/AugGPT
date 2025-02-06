import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public int count=0;
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setChessColor(chessColor);setSource(source);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        if(getChessColor()==ChessColor.WHITE){
            if(getSource().getX()==6){
                if(chessComponent[getSource().getX()-1][getSource().getY()].getName()=='_'){
                    move.add(getSource().offset(-1,0));
                    if(chessComponent[getSource().getX()-2][getSource().getY()].getName()=='_'){
                        move.add(getSource().offset(-2,0));
                    }
                }
            }
            else{
                if(getSource().getX()-1>=0){if(chessComponent[getSource().getX()-1][getSource().getY()].getName()=='_'){move.add(getSource().offset(-1,0));}}
            }
            if(getSource().getX()-1>=0&&getSource().getY()+1<=7){if(chessComponent[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK)move.add(getSource().offset(-1,1));}
            if(getSource().getX()-1>=0&&getSource().getY()-1>=0){if(chessComponent[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK)move.add(getSource().offset(-1,-1));}
        }
        if(getChessColor()==ChessColor.BLACK){
            if(getSource().getX()==1){
                if(chessComponent[getSource().getX()+1][getSource().getY()].getName()=='_'){
                    move.add(getSource().offset(1,0));
                    if(chessComponent[getSource().getX()+2][getSource().getY()].getName()=='_'){
                        move.add(getSource().offset(+2,0));
                    }
                }
            }
            else {
                if(getSource().getX()+1<=7){if(chessComponent[getSource().getX()+1][getSource().getY()].getName()=='_'){move.add(getSource().offset(1,0));}}
            }
            if(getSource().getX()+1<=7&&getSource().getY()+1<=7){if(chessComponent[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE)move.add(getSource().offset(1,1));}
            if(getSource().getX()+1<=7&&getSource().getY()-1>=0){if(chessComponent[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE)move.add(getSource().offset(1,-1));}
        }
        return move;
    }
}
