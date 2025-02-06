import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public  KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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

        return move;
    }
}


