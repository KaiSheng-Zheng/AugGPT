import java.util.*;
public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setChessColor(chessColor);setSource(source);
        this.name = name;
    }

    public List<ChessboardPoint> canMoveTo(){
    List<ChessboardPoint> move=new ArrayList<>() ;
    if(getSource().getX()-1>=0&&getSource().getY()-1>=0){
        if(!isSameColor(chessComponent[getSource().getX()-1][getSource().getY()-1].getSource(),getSource())){
            move.add(getSource().offset(-1,-1));
        }
    }
    if(getSource().getX()-1>=0){
        if(!isSameColor(chessComponent[getSource().getX()-1][getSource().getY()].getSource(),getSource())){
            move.add(getSource().offset(-1,0));
        }
    }
        if(getSource().getX()-1>=0&&getSource().getY()+1<=7){
            if(!isSameColor(chessComponent[getSource().getX()-1][getSource().getY()+1].getSource(),getSource())){
                move.add(getSource().offset(-1,1));
            }
        }
        if(getSource().getY()-1>=0){
            if(!isSameColor(chessComponent[getSource().getX()][getSource().getY()-1].getSource(),getSource())){
                move.add(getSource().offset(0,-1));
            }
        }
        if(getSource().getY()+1<=7){
            if(!isSameColor(chessComponent[getSource().getX()][getSource().getY()+1].getSource(),getSource())){
                move.add(getSource().offset(0,1));
            }
        }
        if(getSource().getX()+1<=7&&getSource().getY()-1>=0){
            if(!isSameColor(chessComponent[getSource().getX()+1][getSource().getY()-1].getSource(),getSource())){
                move.add(getSource().offset(1,-1));
            }
        }
        if(getSource().getX()+1<=7){
            if(!isSameColor(chessComponent[getSource().getX()+1][getSource().getY()].getSource(),getSource())){
                move.add(getSource().offset(1,0));
            }
        }
        if(getSource().getX()+1<=7&&getSource().getY()+1<=7){
            if(!isSameColor(chessComponent[getSource().getX()+1][getSource().getY()+1].getSource(),getSource())){
                move.add(getSource().offset(1,1));
            }
        }
    return move;
    }
}

