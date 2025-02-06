import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    ConcreteChessGame chessGame;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public QueenChessComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> CanMoveList=new ArrayList<>();//
        ChessboardPoint source=getSource();
        ChessComponent[][] chessComponents=chessGame.getChessComponents();
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
            if (source.offset(0,d)!=null){
                if (chessComponents[x][y+d] instanceof EmptySlotComponent){
                    CanMoveList.add(new ChessboardPoint(x,y+d));
                }else if (!(chessComponents[x][y+d]  instanceof EmptySlotComponent) &&chessColor!=chessComponents[x][y+d] .getChessColor()){
                    CanMoveList.add(new ChessboardPoint(x,y+d));
                    break;
                }
            }
            if (source.offset(d,0)!=null){
                if (chessComponents[x+d][y] instanceof EmptySlotComponent){
                    CanMoveList.add(new ChessboardPoint(x+d,y));
                }else if (!(chessComponents[x+d][y+d]  instanceof EmptySlotComponent) &&chessColor!=chessComponents[x+d][y] .getChessColor()){
                    CanMoveList.add(new ChessboardPoint(x+d,y));
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
}
