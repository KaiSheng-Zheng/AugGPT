import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor=chessColor;
        chessboardPoint=source;
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}