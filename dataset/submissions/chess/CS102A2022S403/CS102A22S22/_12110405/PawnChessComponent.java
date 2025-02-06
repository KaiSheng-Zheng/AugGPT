import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){

        super(source,chessColor);
        if (chessColor==ChessColor.BLACK){
            this.name='P';}
        else {
            this.name='p';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
