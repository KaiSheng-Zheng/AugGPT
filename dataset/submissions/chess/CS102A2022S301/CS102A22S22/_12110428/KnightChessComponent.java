import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public KnightChessComponent(ChessColor chessColor){
        if(chessColor == ChessColor.BLACK){
            name='N';
        }else if(chessColor == ChessColor.WHITE){
            name='n';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
