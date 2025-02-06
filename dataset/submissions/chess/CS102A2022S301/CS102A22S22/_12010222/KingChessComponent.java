import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}