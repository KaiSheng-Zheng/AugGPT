import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){

        super(source,chessColor);
        if (chessColor==ChessColor.BLACK){
            this.name='R';}
        else {
            this.name='r';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
