import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] now) {
        setSource(source);
        setChessColor(chessColor);
        setName(name);
        setNow(now);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canChessMove = new ArrayList<>();

        if (getChessColor() == ChessColor.BLACK){
            if (getSource().getX() == 1){
                if (getNow()[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                    if (getNow()[getSource().getX()+2][getSource().getY()].getChessColor() == ChessColor.NONE){
                        canChessMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
                    }
                }
            }else{
                if (getNow()[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                }
            }

            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7){
                if (getNow()[getSource().getX()+1][getSource().getY()+1].getChessColor() != ChessColor.NONE
                        && getNow()[getSource().getX()+1][getSource().getY()+1].getChessColor() != getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                }
            }

            if (getSource().getX()+1>=0 && getSource().getX()+1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7){
                if (getNow()[getSource().getX()+1][getSource().getY()-1].getChessColor() != ChessColor.NONE
                        && getNow()[getSource().getX()+1][getSource().getY()-1].getChessColor() != getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                }
            }

        }else{
            if (getSource().getX() == 6){
                if (getNow()[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                    if (getNow()[getSource().getX()-2][getSource().getY()].getChessColor() == ChessColor.NONE){
                        canChessMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));
                    }
                }
            }else{
                if (getNow()[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                }
            }

            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()-1>=0 && getSource().getY()-1<=7){
                if (getNow()[getSource().getX()-1][getSource().getY()-1].getChessColor() != ChessColor.NONE
                        && getNow()[getSource().getX()-1][getSource().getY()-1].getChessColor() != getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                }
            }

            if (getSource().getX()-1>=0 && getSource().getX()-1<=7 && getSource().getY()+1>=0 && getSource().getY()+1<=7){
                if (getNow()[getSource().getX()-1][getSource().getY()+1].getChessColor() != ChessColor.NONE
                        && getNow()[getSource().getX()-1][getSource().getY()+1].getChessColor() != getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                }
            }
        }

        ArrayList<ChessboardPoint> newCanChessMove = new ArrayList<>();
        for (int i = 0; i < canChessMove.size(); i++) {
            newCanChessMove.add(sort(canChessMove).get(i));
        }

        return newCanChessMove;
    }
}

