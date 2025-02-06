import java.util.*;
import java.util.concurrent.Callable;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponent){
        this.chessColor=chessColor;
        chessboardPoint=source;
        this.name=name;
        this.chessComponents=chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new LinkedList<>();
//        ChessboardPoint destination=new ChessboardPoint(chessboardPoint.getX(),chessboardPoint.getY());
//        for (int i=destination.getX();destination.getX()-i<destination.getX();i--){
//            if ()
//        }
        if (chessColor==ChessColor.BLACK){
            for (int i=1;i<8;i++){


            }
            for (int i=0;i<8;i++){
                if (chessComponents[i][chessboardPoint.getY()]instanceof EmptySlotComponent||chessComponents[i][chessboardPoint.getY()].getChessColor()==ChessColor.WHITE){
                    point.add(new ChessboardPoint(i,chessboardPoint.getY()));
                }
            }
        }else {
            for (int i=0;i<8;i++){
                if (chessComponents[chessboardPoint.getX()][i]instanceof EmptySlotComponent||chessComponents[chessboardPoint.getX()][i].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(chessboardPoint.getX(),i));
                }
            }
            for (int i=0;i<8;i++){
                if (chessComponents[i][chessboardPoint.getY()]instanceof EmptySlotComponent||chessComponents[i][chessboardPoint.getY()].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(i,chessboardPoint.getY()));
                }
            }
        }
        return point;
    }
}
