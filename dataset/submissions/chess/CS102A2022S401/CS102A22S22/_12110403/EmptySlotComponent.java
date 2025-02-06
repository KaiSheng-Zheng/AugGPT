import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private char name;
    ChessColor color;
    ChessboardPoint point;
    ChessComponent[][] chessComponents=new ChessComponent[8][8];
    public EmptySlotComponent(char name,ChessboardPoint point,ChessComponent[][] chessComponents){
        this.name=name;
        this.point=point;
        this.chessComponents=chessComponents;
        color=ChessColor.NONE;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return color;}
    public void moveTo(ChessboardPoint target) {
        point = target;
    }
}