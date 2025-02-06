import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    			// What's the name
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super();
        super.name=name;
        this.chessColor=chessColor;
        this.source=source;
        super.chessColor1=chessColor;
    }
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public void changeSource(int x,int y){
        source=new ChessboardPoint(x,y);
    }

}
