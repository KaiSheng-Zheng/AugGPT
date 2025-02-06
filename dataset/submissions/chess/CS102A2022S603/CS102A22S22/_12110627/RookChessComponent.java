import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name=name;
        setChessColor(chessColor);
        setSource(source);
    }
    public ChessComponent[][] getChessComponent(){
        return chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>move=new ArrayList<>();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
            }
        }

        return move;
    }
}
