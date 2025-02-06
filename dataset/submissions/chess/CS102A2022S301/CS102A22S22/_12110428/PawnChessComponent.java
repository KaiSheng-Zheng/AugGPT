import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public PawnChessComponent(ChessColor chessColor ){
        if(chessColor == ChessColor.BLACK){
            name='P';
        }else if(chessColor == ChessColor.WHITE){
            name='p';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
