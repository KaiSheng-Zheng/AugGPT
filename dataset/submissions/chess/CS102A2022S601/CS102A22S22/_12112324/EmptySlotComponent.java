import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public EmptySlotComponent(ChessboardPoint source){
        this.source = source;
        this.chessColor = ChessColor.NONE;
        this.name = '_';
    }
    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public void setChessboardPoint(ChessboardPoint chessboardPoint){
        source=chessboardPoint;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<ChessboardPoint>();
    }
    @Override
    public void setChessComponent(ChessComponent[][] chessComponent) {}
    @Override
    public ChessComponent[][] getChessComponent(){
        return null;
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}