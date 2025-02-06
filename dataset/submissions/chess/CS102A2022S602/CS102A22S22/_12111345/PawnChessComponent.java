import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent (ChessboardPoint source,ChessColor chessColor, char name){
        super(source,chessColor,name);
    }
    public PawnChessComponent(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    public List<ChessboardPoint> canMoveTo(){
        return null;
    }
}
