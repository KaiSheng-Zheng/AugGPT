import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        if (getChessColor()==ChessColor.BLACK && getSource().getX()==1){
            if (chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                if (chessComponents[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
                }
            }

            if (chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE && getSource().getY()+1<8){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
            if (chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE && getSource().getY()>0){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            }
        }
        else if (getChessColor()==ChessColor.BLACK && getSource().getX()!=1 && getSource().getX()!=7){
            if (chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }

            if (chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE && getSource().getY()+1<8){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
            if (chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE && getSource().getY()>0){
                result.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            }
        }
        else if (getChessColor()==ChessColor.WHITE && getSource().getX()==6){
            if (chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                if (chessComponents[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE){
                    result.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));
                }
            }

            if (chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK && getSource().getY()+1<8){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if (chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK && getSource().getY()>0){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
        }
        else if (getChessColor()==ChessColor.WHITE && getSource().getX()!=6 && getSource().getX()!=0){
            if (chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
            }

            if (chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK && getSource().getY()+1<8){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if (chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK && getSource().getY()>0){
                result.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
        }
        return result;
    }
}
