import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){

        super(source,chessColor);
        if (chessColor==ChessColor.BLACK){
            this.name='B';}
        else {
            this.name='b';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}