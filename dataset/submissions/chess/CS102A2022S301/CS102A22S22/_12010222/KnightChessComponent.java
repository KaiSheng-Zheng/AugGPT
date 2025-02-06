import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}