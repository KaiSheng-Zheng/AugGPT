import java.util.LinkedList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponent){
        this.chessColor=chessColor;
        chessboardPoint=source;
        this.name=name;
        this.chessComponents = chessComponent;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new LinkedList<>();
        if (chessColor==ChessColor.BLACK){
            if (chessboardPoint.getY()==0){
                if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                    point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()));
                }
                if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+1].getChessColor()==ChessColor.WHITE){
                    point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()+1));
                }
                if (chessboardPoint.getX()==1) {
                    if (chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                        if (chessComponents[chessboardPoint.getX() + 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                            point.add(new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()));
                        }
                    }
                }
                return point;
            }
            if (chessboardPoint.getY()==7){
                if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-1].getChessColor()==ChessColor.WHITE){
                    point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()-1));
                }
                if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                    point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()));
                }
                if (chessboardPoint.getX()==1) {
                    if (chessComponents[chessboardPoint.getX()+ 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                        if (chessComponents[chessboardPoint.getX() + 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                            point.add(new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()));
                        }
                    }
                }
                return point;
            }
            if (chessboardPoint.getX()==7){
                return null;
            }
            if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()-1].getChessColor()==ChessColor.WHITE){
                point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()-1));
            }
            if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()));
            }
            if (chessComponents[chessboardPoint.getX()+1][chessboardPoint.getY()+1].getChessColor()==ChessColor.WHITE){
                point.add(new ChessboardPoint(chessboardPoint.getX()+1,chessboardPoint.getY()+1));
            }
            if (chessboardPoint.getX()==1) {
                if (chessComponents[chessboardPoint.getX() + 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                    if (chessComponents[chessboardPoint.getX() + 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                        point.add(new ChessboardPoint(chessboardPoint.getX()+2,chessboardPoint.getY()));
                    }
                }
            }
        }else {
            if (chessboardPoint.getX()==0){
                return null;
            }
            if (chessboardPoint.getY()==0){
                if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                    point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()));
                }
                if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()+1));
                }
                if (chessboardPoint.getX()==6) {
                    if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                        if (chessComponents[chessboardPoint.getX() - 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                            point.add(new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()));
                        }
                    }
                }
                return point;
            }
            if (chessboardPoint.getY()==7){
                if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()-1));
                }
                if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                    point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()));
                }
                if (chessboardPoint.getX()==6) {
                    if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                        if (chessComponents[chessboardPoint.getX() - 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                            point.add(new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()));
                        }
                    }
                }
                return point;
            }
            if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()-1].getChessColor()==ChessColor.BLACK){
                point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()-1));
            }
            if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()]instanceof EmptySlotComponent){
                point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()));
            }
            if (chessComponents[chessboardPoint.getX()-1][chessboardPoint.getY()+1].getChessColor()==ChessColor.BLACK){
                point.add(new ChessboardPoint(chessboardPoint.getX()-1,chessboardPoint.getY()+1));
            }
            if (chessboardPoint.getX()==6) {
                if (chessComponents[chessboardPoint.getX() - 1][chessboardPoint.getY()] instanceof EmptySlotComponent) {
                    if (chessComponents[chessboardPoint.getX() - 2][chessboardPoint.getY()] instanceof EmptySlotComponent){
                        point.add(new ChessboardPoint(chessboardPoint.getX()-2,chessboardPoint.getY()));
                    }
                }
            }
        }
        return point;
    }
    public void setSource(ChessboardPoint source) {
        this.chessboardPoint = source;
    }
}



