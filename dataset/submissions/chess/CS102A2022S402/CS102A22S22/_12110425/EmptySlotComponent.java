import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char a,int x,int y,ChessComponent[][] chessComponents){
        super(x, y);
        this.chessComponents = chessComponents;
        this.name = a;
        setChessColor(ChessColor.NONE);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> New = new ArrayList<>();
        System.out.println(this.name);
        return New;
    }
}
