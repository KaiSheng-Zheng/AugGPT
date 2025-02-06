import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        if(getChessColor()==ChessColor.BLACK){
            if(getSource().getX()==1){
                if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    points.add(new ChessboardPoint((getSource().getX()+1), getSource().getY()));
                    if(ChessComponent.chessComponents[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE){
                        points.add(new ChessboardPoint((getSource().getX()+2), getSource().getY()));
                    }
                }
            }
             if(getSource().getX()+1<8&&getSource().getY()-1>=0) {
                if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                    points.add(new ChessboardPoint((getSource().getX() + 1), (getSource().getY() - 1)));
                }
            }
             if(getSource().getX()+1<8&&getSource().getY()+1<8) {
                if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                    points.add(new ChessboardPoint((getSource().getX() + 1), (getSource().getY() + 1)));
                }
            }
             if(getSource().getX()+1<8){
                if(ChessComponent.chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    points.add(new ChessboardPoint((getSource().getX()+1), getSource().getY()));
                }
            }
        }
         if(getChessColor()==ChessColor.WHITE){
            if(getSource().getX()==6){
                if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    points.add(new ChessboardPoint((getSource().getX()-1), getSource().getY()));
                    if(ChessComponent.chessComponents[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE){
                        points.add(new ChessboardPoint((getSource().getX()-2), getSource().getY()));
                    }
                }
            }
              if(getSource().getX()-1>=0&&getSource().getY()-1>=0) {
                if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    points.add(new ChessboardPoint((getSource().getX() - 1), (getSource().getY() - 1)));
                }
            }
             if(getSource().getX()-1>=0&&getSource().getY()+1<8) {
                if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    points.add(new ChessboardPoint((getSource().getX() - 1), (getSource().getY() + 1)));
                }
            }
             if(getSource().getX()-1>=0){
                if(ChessComponent.chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE){
                    points.add(new ChessboardPoint((getSource().getX()-1), getSource().getY()));
                }
            }
        }
        return points;
    }
}
