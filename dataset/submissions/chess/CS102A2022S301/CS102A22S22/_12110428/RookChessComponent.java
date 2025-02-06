import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public RookChessComponent(ChessColor chessColor){
        if(chessColor == ChessColor.BLACK){
            name='R';
        }else if(chessColor == ChessColor.WHITE){
            name='r';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
