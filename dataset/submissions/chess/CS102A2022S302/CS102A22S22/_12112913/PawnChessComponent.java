import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name) {
        this.name = name;
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> result = new ArrayList<>();
        ChessComponent[][] chessComponents = super.currentChessboard.getChessComponents();
        ChessColor player = super.currentChessboard.getCurrentPlayer();
        if (player == ChessColor.WHITE){
            if ((super.getSource().offset(1,-1) != null) && !(chessComponents[getSource().getX() + 1][getSource().getY() - 1] instanceof EmptySlotComponent)){
                result.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() - 1));
            }
            if ((super.getSource().offset(-1,-1) != null) && !(chessComponents[getSource().getX() - 1][getSource().getY() - 1] instanceof EmptySlotComponent)){
                result.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() - 1));
            }

            if (getSource().getY() == 6){
                if (chessComponents[getSource().getX()][getSource().getY() - 1] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 1));
                }
                if (chessComponents[getSource().getX()][getSource().getY() - 2] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 2));
                }
            }else{
                if ((super.getSource().offset(0,-1) != null) && chessComponents[getSource().getX()][getSource().getY() - 1] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 1));
                }
            }
        }else{
            if ((super.getSource().offset(1,1) != null) && !(chessComponents[getSource().getX() + 1][getSource().getY() + 1] instanceof EmptySlotComponent)){
                result.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() + 1));
            }
            if ((super.getSource().offset(-1,1) != null) && !(chessComponents[getSource().getX() - 1][getSource().getY() + 1] instanceof EmptySlotComponent)){
                result.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() + 1));
            }

            if (getSource().getY() == 1){
                if (chessComponents[getSource().getX()][getSource().getY() + 1] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 1));
                }
                if (chessComponents[getSource().getX()][getSource().getY() + 2] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 2));
                }
            }else{
                if ((super.getSource().offset(0,1) != null) && chessComponents[getSource().getX()][getSource().getY() + 1] instanceof EmptySlotComponent){
                    result.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 1));
                }
            }
        }
        return result;
    }
}
