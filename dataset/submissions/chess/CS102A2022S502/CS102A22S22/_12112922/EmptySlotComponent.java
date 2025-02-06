import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
//        super(source,chessColor);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents = chessComponents;
        super.name = '_';
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        return canMoveTo;
    }
    public void updateBoard(ChessComponent[][] newBoard){
        this.chessComponents = newBoard;
    }
}
