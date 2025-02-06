import java.util.ArrayList;
import java.util.List;

public class EmptyChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    private ChessColor chessColor;
    private List<ChessboardPoint> list = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return list;
    }
    public EmptyChessComponent(){
    }

    public EmptyChessComponent(ChessboardPoint source,ChessComponent[][]chessComponents, ChessColor chessColor, char name){
        super(source,chessComponents, chessColor, name);
        this.name = name;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }
}
