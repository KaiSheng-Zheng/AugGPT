import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}