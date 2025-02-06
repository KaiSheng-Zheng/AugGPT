import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public QueenChessComponent(ChessColor chessColor){
        if(chessColor == ChessColor.BLACK){
            name='Q';
        }else if(chessColor == ChessColor.WHITE){
            name='q';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
