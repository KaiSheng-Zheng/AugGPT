import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ConcreteChessGame chessGame;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public BishopChessComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> CanMoveList=new ArrayList<>();//
        ChessboardPoint source=this.source;
        ChessComponent[][] chessComponents=this.chessGame.getChessComponents();
        int x=source.getX();
        int y=source.getY();
        for (int d=-8;d<8;d++){
            if (source.offset(d,d)!=null){
                if (chessComponents[x+d][y+d] instanceof EmptySlotComponent){
                    CanMoveList.add(new ChessboardPoint(x+d,y+d));
                }else if (!(chessComponents[x+d][y+d]  instanceof EmptySlotComponent) &&chessColor!=chessComponents[x+d][y+d] .getChessColor()){
                    CanMoveList.add(new ChessboardPoint(x+d,y+d));
                    break;
                }
                if (chessComponents[x-d][y+d] instanceof EmptySlotComponent){
                    CanMoveList.add(new ChessboardPoint(x-d,y+d));
                }else if (!(chessComponents[x-d][y+d]  instanceof EmptySlotComponent) &&chessColor!=chessComponents[x-d][y+d] .getChessColor()){
                    CanMoveList.add(new ChessboardPoint(x-d,y+d));
                    break;
                }
            }
        }
        if (CanMoveList.isEmpty()){
            return null;
        }else {
            return CanMoveList;
        }

    }
    @Override
    public String toString() {
        if (chessColor==ChessColor.NONE){
            return "_";
        }
        return String.valueOf(this.name);
    }
}

