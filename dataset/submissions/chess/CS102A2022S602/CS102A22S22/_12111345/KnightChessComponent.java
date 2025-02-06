import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent (ChessboardPoint source,ChessColor chessColor, char name){
        super(source,chessColor,name);
    }
    public KnightChessComponent(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    public List<ChessboardPoint> canMoveTo(){
        return null;
    }
}
