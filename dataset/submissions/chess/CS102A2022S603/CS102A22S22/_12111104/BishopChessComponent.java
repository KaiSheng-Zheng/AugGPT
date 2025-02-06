import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor=chessColor;
        chessboardPoint=source;
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}