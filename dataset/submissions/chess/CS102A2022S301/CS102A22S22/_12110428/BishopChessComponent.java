import java.util.List;

public class BishopChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
    public BishopChessComponent(ChessColor chessColor){
        if(chessColor == ChessColor.BLACK){
            name='B';
        }else if(chessColor == ChessColor.WHITE){
            name='b';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
