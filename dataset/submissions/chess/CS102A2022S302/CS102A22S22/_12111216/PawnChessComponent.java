import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor h, ChessboardPoint source){
        if(h.equals(ChessColor.BLACK))this.name='P';
        else this.name = 'p';
        this.setSource(source);
        this.setChessColor(h);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> hou = new ArrayList<>();
        if(this.getChessColor().equals(ChessColor.BLACK)){
            if (getSource().getX() + 1 <= 7 && chessComponents[getSource().getX() + 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                hou.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
            }
            if(getSource().getX()==1&& getSource().getX()+2<=7&&chessComponents[getSource().getX()+2][getSource().getY()].getChessColor().equals(ChessColor.NONE)){hou.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()));}
            if(checkInbound(getSource().getX()+1)&&checkInbound(getSource().getY()+1)&&chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor().equals(ChessColor.WHITE)){hou.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));}
            if(checkInbound(getSource().getX()+1)&&checkInbound(getSource().getY()-1)&&chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor().equals(ChessColor.WHITE)){hou.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));}
        }
        if(this.getChessColor().equals(ChessColor.WHITE)){
            if (checkInbound(getSource().getX() -1 ) && chessComponents[getSource().getX() - 1][getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                hou.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
            }
            if(getSource().getX()==6&&chessComponents[getSource().getX()+2][getSource().getY()].getChessColor().equals(ChessColor.NONE)){hou.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()));}
            if(checkInbound(getSource().getX()-1)&&checkInbound(getSource().getY()+1)&&chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor().equals(ChessColor.BLACK)){hou.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));}
            if(checkInbound(getSource().getX()-1)&&checkInbound(getSource().getY()-1)&&chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor().equals(ChessColor.BLACK)){hou.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));}
        }
        Collections.sort(hou);
        return hou;

    }

    public String toString() {
        return name+"";
    }
}
