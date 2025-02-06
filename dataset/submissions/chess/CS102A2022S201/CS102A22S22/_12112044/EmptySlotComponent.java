import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent  {
    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint source;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.chessColor = chessColor;
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
        super.setChessColor(chessColor);
        super.setName(name);
        super.setSource(source);
        super.setChessComponents(chessComponents);
    }
}
