import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{
    ChessboardPoint source;
    ChessColor chessColor;
    @Override
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public EmptySlotComponent(int x, int y,char name){
        source = new ChessboardPoint(x,y);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
