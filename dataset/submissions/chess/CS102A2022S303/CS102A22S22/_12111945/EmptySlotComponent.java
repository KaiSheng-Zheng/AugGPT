import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public String toString() {
        this.name = '_';
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public boolean canMoveTo(ChessboardPoint target){
        return false;
    }
}
