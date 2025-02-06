import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public EmptySlotComponent(int x,int y,ChessColor color,char name){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x,y);
        this.source = chessboardPoint;
        this.chessColor = color;
        super.name = name;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        return list;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public ChessColor getChessColor(){
        return chessColor;
    }

    @Override
    public void setSource(int x,int y){
        this.source = new ChessboardPoint(x,y);
    }
}
