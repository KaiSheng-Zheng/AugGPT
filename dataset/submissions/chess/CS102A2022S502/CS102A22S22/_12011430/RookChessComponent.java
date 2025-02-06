import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }
    public RookChessComponent() {}
    public  List<ChessboardPoint> canMoveTo(){
        ChessComponent[][] chessComponents=chessGame.getChessComponents();
        List<ChessboardPoint> CanMoveList=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        for (int d=-8;d<8;d++){
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
            return new ArrayList<>();
        }else {
            return CanMoveList;
        }

    }
}
