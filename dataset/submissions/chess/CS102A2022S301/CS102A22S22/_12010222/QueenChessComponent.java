import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}