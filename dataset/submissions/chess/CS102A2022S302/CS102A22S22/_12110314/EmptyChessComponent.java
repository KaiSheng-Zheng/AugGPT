import java.util.List;

public class EmptyChessComponent extends ChessComponent{
    public EmptyChessComponent(){
        super();
        name='_';
    }
    public EmptyChessComponent(int x,int y){
        super(x, y);
        name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
