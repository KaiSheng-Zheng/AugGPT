import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent [][]chessComponents;
    public char getName() {
        return name;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public EmptySlotComponent(ChessboardPoint source,ChessColor color,ChessComponent [][]chessComponents){
        this.source=source;
        this.chessColor=color;
        this.name='_';
        this.chessComponents=chessComponents;
    }

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
