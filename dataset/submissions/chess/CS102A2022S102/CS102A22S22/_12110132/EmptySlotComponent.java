import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(char name,char color,int x,int y,ConcreteChessGame game){
        super(name,color,x,y);
        this.game = game;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public String toString(){
        return "_";
    }
}
