import java.util.ArrayList;
import java.util.List;
public class EmptyChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> chesslist = new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return chesslist;
    }
    public EmptyChessComponent(ChessboardPoint point, ChessComponent[][]chessComponents, ChessColor chessColor, char a){
        super(point, chessColor, a);
        this.a = a;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }
}
