import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public KingChessComponent(ChessColor chessColor){
        if(chessColor == ChessColor.BLACK){
            name='K';
        }else if(chessColor == ChessColor.WHITE){
            name='k';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
