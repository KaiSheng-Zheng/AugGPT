import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}