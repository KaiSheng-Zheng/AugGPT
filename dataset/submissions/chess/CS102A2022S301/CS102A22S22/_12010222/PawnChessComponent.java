import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name,ChessColor chessColor){
        this.name=name;
        setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){return null;}
}