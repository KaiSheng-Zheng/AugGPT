import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor=chessColor;
        chessboardPoint=source;
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
