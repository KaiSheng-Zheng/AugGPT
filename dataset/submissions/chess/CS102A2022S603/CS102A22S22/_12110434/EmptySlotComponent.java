import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor chessColor;
    private ChessboardPoint chessboardPoint;

    protected EmptySlotComponent(char name, ChessColor none, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
        this.name=name;
        this.chessboardPoint=chessboardPoint;
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){return chessColor;}
    public void moveTo(ChessboardPoint target) {
        chessboardPoint = target;
    }
}

